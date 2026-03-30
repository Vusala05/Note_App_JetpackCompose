package com.example.to_do_app_jetpackcompose.data.data_source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.to_do_app_jetpackcompose.data.data_source.local.dao.NoteDao
import com.example.to_do_app_jetpackcompose.data.data_source.local.model.NoteEntity
import com.example.to_do_app_jetpackcompose.domain.model.Note

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNoteDao() : NoteDao
}