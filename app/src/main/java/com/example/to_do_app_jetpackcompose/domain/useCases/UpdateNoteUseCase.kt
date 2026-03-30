package com.example.to_do_app_jetpackcompose.domain.useCases

import com.example.to_do_app_jetpackcompose.domain.model.Note
import com.example.to_do_app_jetpackcompose.domain.repository.NoteRepository

class UpdateNoteUseCase(private val repository: NoteRepository) {

    suspend operator fun invoke(note: Note) {
        repository.updateNote(note)

    }
}