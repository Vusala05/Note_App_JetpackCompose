package com.example.to_do_app_jetpackcompose.core.di

import com.example.to_do_app_jetpackcompose.domain.repository.NoteRepository
import com.example.to_do_app_jetpackcompose.domain.useCases.DeleteNoteUseCase
import com.example.to_do_app_jetpackcompose.domain.useCases.GetAllNotesUseCase
import com.example.to_do_app_jetpackcompose.domain.useCases.GetNoteByIdUseCase
import com.example.to_do_app_jetpackcompose.domain.useCases.InsertNoteUseCase
import com.example.to_do_app_jetpackcompose.domain.useCases.NoteUseCases
import com.example.to_do_app_jetpackcompose.domain.useCases.UpdateNoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {
    @Provides
    @Singleton
    fun provideNoteUsesCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getAllNotesUseCase = GetAllNotesUseCase(repository),
            getNoteByIdUseCase = GetNoteByIdUseCase(repository),
            updateNoteUseCase = UpdateNoteUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
            insertNoteUseCase = InsertNoteUseCase(repository)
        )
    }
}