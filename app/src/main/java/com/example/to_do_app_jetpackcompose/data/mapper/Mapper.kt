package com.example.to_do_app_jetpackcompose.data.mapper

import com.example.to_do_app_jetpackcompose.data.data_source.local.model.NoteEntity
import com.example.to_do_app_jetpackcompose.domain.model.Note


    fun NoteEntity.toNote(): Note {
        return Note(
            id = id,
            text = text,
            isDone = isDone
        )
    }

    fun Note.toNoteEntity(): NoteEntity {
        return NoteEntity(
            id = id,
            text = text,
            isDone = isDone
        )
    }
