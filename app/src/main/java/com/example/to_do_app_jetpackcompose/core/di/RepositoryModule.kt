package com.example.to_do_app_jetpackcompose.core.di

import com.example.to_do_app_jetpackcompose.data.repository.NoteRepositoryImpl
import com.example.to_do_app_jetpackcompose.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindNoteRepository(noteRepositoryImpl : NoteRepositoryImpl) : NoteRepository
}