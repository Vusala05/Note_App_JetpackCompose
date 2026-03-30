package com.example.to_do_app_jetpackcompose.presentation.home

import com.example.to_do_app_jetpackcompose.core.common.NoteFilter
import com.example.to_do_app_jetpackcompose.domain.model.Note

sealed class NoteEvent{
    object LoadNotes : NoteEvent()
    data class AddNote (val note : Note) : NoteEvent()
    data class DeleteNote (val note : Note) : NoteEvent()
    data class UpdateNote(val note: Note, val text : String) : NoteEvent()
    data class MarkNoteDone (val note : Note) : NoteEvent()
    data class ChangeFilter (val noteFilter: NoteFilter) : NoteEvent()
    data object RestoreNote : NoteEvent()
    data class SelectNoteForEdit(val note : Note?) : NoteEvent()

}