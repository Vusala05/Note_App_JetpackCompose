package com.example.to_do_app_jetpackcompose.presentation.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.to_do_app_jetpackcompose.domain.model.Note
import com.example.to_do_app_jetpackcompose.presentation.home.components.HomeBottomSection
import com.example.to_do_app_jetpackcompose.presentation.home.components.HomeScreenTopSection
import com.example.to_do_app_jetpackcompose.presentation.home.components.NoteItem
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun HomeScreen(
    state: NoteState,
    effect: SharedFlow<NoteEffect>,
    postIntent: (NoteEvent) -> Unit,
) {
    val snackBarHostState = remember { SnackbarHostState() }
    LaunchedEffect(effect) {
        effect.collect {
            when (it) {
                is NoteEffect.OnShowError -> snackBarHostState.showSnackbar(
                    message = it.message,
                    duration = SnackbarDuration.Short,
                )

                is NoteEffect.OnShowSuccess -> {
                    snackBarHostState.showSnackbar(
                        message = it.message,
                        duration = SnackbarDuration.Short,

                        )

                }

                is NoteEffect.OnShowUndo -> {
                    val result = snackBarHostState.showSnackbar(
                        message = it.message,
                        actionLabel = "UNDO",
                        duration = SnackbarDuration.Short,
                    )
                    if (result == SnackbarResult.ActionPerformed) {
                        postIntent(NoteEvent.RestoreNote)
                    }
                }
            }
        }
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,
        snackbarHost = { SnackbarHost(snackBarHostState)},
        topBar = {
            HomeScreenTopSection(
                selectedFilter = state.noteFilter,
                onFilterSelected = { filter ->
                    postIntent(NoteEvent.ChangeFilter(filter))
                }
            )
        },
        bottomBar = {
            HomeBottomSection(
                selectedNote = state.selectedNote,
                onAddClick = { inputText ->
                    val newNote = Note(text = inputText)
                    postIntent(NoteEvent.AddNote(newNote))
                },
                onEditClick = { note, newText ->
                    postIntent(NoteEvent.UpdateNote(note,newText))
                }
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
                .padding(innerPadding)
                .padding(top = 17.dp, bottom = 22.dp)

        ) {
            items(state.notesList, key = {it.id}){ note->
                NoteItem(
                    note= note,
                    onStatusChange = {
                       postIntent(NoteEvent.MarkNoteDone(note))
                    },
                    onItemDeleted = {
                        postIntent(NoteEvent.DeleteNote(note))
                    },
                    onNoteClick = {
                        postIntent(NoteEvent.SelectNoteForEdit(note))
                    }
                )
            }
        }

    }
}
