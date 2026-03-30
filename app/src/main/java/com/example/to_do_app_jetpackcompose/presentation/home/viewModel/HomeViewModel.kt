package com.example.to_do_app_jetpackcompose.presentation.home.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_do_app_jetpackcompose.core.common.NoteFilter
import com.example.to_do_app_jetpackcompose.domain.useCases.NoteUseCases
import com.example.to_do_app_jetpackcompose.presentation.home.NoteEffect
import com.example.to_do_app_jetpackcompose.presentation.home.NoteEvent
import com.example.to_do_app_jetpackcompose.presentation.home.NoteState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.to_do_app_jetpackcompose.core.common.Result
import com.example.to_do_app_jetpackcompose.domain.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(NoteState())
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<NoteEffect>()
    val effect = _effect.asSharedFlow()

    private var recentlyDeletedNote : Note? = null
    private var getNotesJob : Job? = null

    init {
        onEvent(NoteEvent.LoadNotes)
    }

    fun onEvent(event: NoteEvent) {
        when (event) {
            is NoteEvent.LoadNotes -> {
                loadNotes(_state.value.noteFilter)
            }

            is NoteEvent.ChangeFilter -> {
                if (_state.value.noteFilter == event.noteFilter) {
                    return
                }
                _state.value = _state.value.copy(noteFilter = event.noteFilter)
                loadNotes(event.noteFilter)
            }

            is NoteEvent.AddNote -> {
                viewModelScope.launch {
                    try {
                        noteUseCases.insertNoteUseCase(event.note)
                        _effect.emit(NoteEffect.OnShowSuccess("Note uğurla əlavə edildi!"))
                    } catch (e: Exception) {
                        _effect.emit(NoteEffect.OnShowError(e.message ?: "Xəta baş verdi"))
                    }
                }
            }

            is NoteEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteUseCases.deleteNoteUseCase(event.note)
                    recentlyDeletedNote = event.note
                    _effect.emit(NoteEffect.OnShowUndo("Silinmiş notu geri qaytar"))

                }
            }
            is NoteEvent.SelectNoteForEdit ->{
                _state.update { it.copy(selectedNote = event.note) }
            }

            is NoteEvent.UpdateNote -> {
                updateNote(event.note,event.text)
            }

            is NoteEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCases.insertNoteUseCase(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }

            is NoteEvent.MarkNoteDone -> {
                viewModelScope.launch {
                    val updatedNote = event.note.copy(isDone = true)
                    noteUseCases.updateNoteUseCase(updatedNote)
                }
            }
        }
    }
    private fun updateNote(note: Note, newText: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val updatedNote = note.copy(text = newText)

            noteUseCases.updateNoteUseCase(updatedNote)
            _state.update { it.copy(selectedNote = null) }
        }
    }

    private fun loadNotes(filter: NoteFilter) {
        getNotesJob?.cancel()
        getNotesJob = noteUseCases.getAllNotesUseCase(filter).onEach { result ->
            when (result) {
               is Result.Success -> {
                    _state.value = _state.value.copy(
                        notesList = result.data ?: emptyList()
                    )
                }


                is Result.Error -> viewModelScope.launch{
                    _effect.emit(NoteEffect.OnShowError(result.message ?: "Error"))
                }
            }
        }.launchIn(viewModelScope)
    }
}