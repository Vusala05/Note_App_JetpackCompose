package com.example.to_do_app_jetpackcompose.data.data_source.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val text : String,
    val isDone : Boolean = false
)