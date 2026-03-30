package com.example.to_do_app_jetpackcompose.domain.useCases

data class NoteUseCases(
val getAllNotesUseCase: GetAllNotesUseCase,
val insertNoteUseCase: InsertNoteUseCase,
val updateNoteUseCase: UpdateNoteUseCase,
val deleteNoteUseCase: DeleteNoteUseCase,
val getNoteByIdUseCase: GetNoteByIdUseCase
)