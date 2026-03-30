package com.example.to_do_app_jetpackcompose.presentation.home

import com.example.to_do_app_jetpackcompose.core.common.NoteFilter
import com.example.to_do_app_jetpackcompose.domain.model.Note

data class NoteState(
    val notesList : List<Note> = emptyList(),
    val noteFilter : NoteFilter = NoteFilter.ALL,
    val selectedNote : Note? = null,
    )