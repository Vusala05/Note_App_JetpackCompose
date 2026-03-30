package com.example.to_do_app_jetpackcompose.domain.useCases

import com.example.to_do_app_jetpackcompose.core.common.NoteFilter
import com.example.to_do_app_jetpackcompose.core.common.Result
import com.example.to_do_app_jetpackcompose.domain.model.Note
import com.example.to_do_app_jetpackcompose.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class GetAllNotesUseCase(private val repository: NoteRepository) {

    operator fun invoke(
        noteFilter: NoteFilter = NoteFilter.ALL
    ): Flow<Result<List<Note>>> {
        return repository.getAllNotes()
            .map { notes ->
                val filteredNotes = when (noteFilter) {
                    NoteFilter.ALL -> notes
                    NoteFilter.COMPLETED -> notes.filter { it.isDone }
                    NoteFilter.ACTIVE -> notes.filter { !it.isDone }
                }
                Result.Success(filteredNotes) as Result<List<Note>>
            }
            .catch { e ->
                emit(Result.Error(e.message ?: "Bilinməyən Xəta Baş Verdi!"))
            }
    }
}