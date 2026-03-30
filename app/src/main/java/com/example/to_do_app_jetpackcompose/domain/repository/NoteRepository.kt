package com.example.to_do_app_jetpackcompose.domain.repository

import com.example.to_do_app_jetpackcompose.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getAllNotes() : Flow<List<Note>>

    suspend fun insertNotes(note: Note)

    suspend fun deleteNote(note : Note)

    suspend fun updateNote (note : Note)

    suspend fun getNoteById (noteId : Int) : Note?
}