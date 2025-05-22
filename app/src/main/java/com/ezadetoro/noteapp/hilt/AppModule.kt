package com.ezadetoro.noteapp.hilt

import com.ezadetoro.noteapp.repository.NoteRepository
import com.ezadetoro.noteapp.repository.NoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindRepo(
        impl: NoteRepositoryImpl
    ): NoteRepository
}