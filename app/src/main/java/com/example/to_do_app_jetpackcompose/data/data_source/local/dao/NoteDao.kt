package com.example.to_do_app_jetpackcompose.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.to_do_app_jetpackcompose.data.data_source.local.model.NoteEntity
import com.example.to_do_app_jetpackcompose.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
        @Insert
        suspend fun insertNote(note: NoteEntity)

        @Delete
        suspend fun deleteNote(note: NoteEntity)

        @Update
        suspend fun updateNote(note: NoteEntity)

        @Query("SELECT * FROM NoteEntity ORDER BY id DESC")
        fun getAllNotes(): Flow<List<NoteEntity>>

        @Query("SELECT * FROM NoteEntity WHERE id = :noteId")
        suspend fun getNoteById(noteId: Int): NoteEntity?

    /*@Query("SELECT * FROM NoteEntity WHERE isDone = 0 ORDER BY id DESC ")
    fun getActiveNotes() : Flow<List<NoteEntity>>

    @Query("SELECT * FROM NoteEntity WHERE isDone = 1 ORDER BY id DESC")
    fun getCompletedNotes() : Flow<List<NoteEntity>>*/
}