package com.example.to_do_app_jetpackcompose.data.repository

import com.example.to_do_app_jetpackcompose.data.data_source.local.dao.NoteDao
import com.example.to_do_app_jetpackcompose.data.mapper.toNote
import com.example.to_do_app_jetpackcompose.data.mapper.toNoteEntity
import com.example.to_do_app_jetpackcompose.domain.model.Note
import com.example.to_do_app_jetpackcompose.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository {

    override fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes().map { list ->
            list.map { it.toNote() }
        }
    }

    override suspend fun insertNotes(note: Note) {
        noteDao.insertNote(note.toNoteEntity())
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toNoteEntity())
    }

    override suspend fun updateNote(note: Note) {
        noteDao.updateNote(note.toNoteEntity())
    }

    override suspend fun getNoteById(noteId: Int): Note? {
        val entity = noteDao.getNoteById(noteId)
        return entity?.toNote()
    }
}