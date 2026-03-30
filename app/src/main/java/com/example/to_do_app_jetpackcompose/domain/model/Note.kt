package com.example.to_do_app_jetpackcompose.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Note(
    val id : Int = 0,
    val text : String,
    val isDone : Boolean = false
)