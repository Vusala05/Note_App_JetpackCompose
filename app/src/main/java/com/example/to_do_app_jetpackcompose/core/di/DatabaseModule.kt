package com.example.to_do_app_jetpackcompose.core.di

import android.content.Context
import androidx.room.Room
import com.example.to_do_app_jetpackcompose.core.common.util.Const.DATABASE_NAME
import com.example.to_do_app_jetpackcompose.data.data_source.local.dao.NoteDao
import com.example.to_do_app_jetpackcompose.data.data_source.local.database.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(@ApplicationContext context: Context) : NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(db : NoteDatabase) : NoteDao {
        return  db.getNoteDao()
    }
}