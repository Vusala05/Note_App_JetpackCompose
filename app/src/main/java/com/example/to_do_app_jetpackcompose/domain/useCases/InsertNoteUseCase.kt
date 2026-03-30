package com.example.to_do_app_jetpackcompose.domain.useCases

import com.example.to_do_app_jetpackcompose.core.common.InvalidException
import com.example.to_do_app_jetpackcompose.domain.model.Note
import com.example.to_do_app_jetpackcompose.domain.repository.NoteRepository

class InsertNoteUseCase(private val repository: NoteRepository) {

    @Throws(InvalidException::class)
    suspend operator fun invoke (note : Note) {

        if (note.text.isBlank()) {
            throw InvalidException("The text of note can't be empty!")
        }

        repository.insertNotes(note)

    }
}