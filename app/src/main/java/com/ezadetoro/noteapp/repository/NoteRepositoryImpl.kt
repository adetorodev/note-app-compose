package com.ezadetoro.noteapp.repository

import com.ezadetoro.noteapp.Data.NoteDao
import com.ezadetoro.noteapp.Data.NoteEntity
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NoteRepositoryImpl @Inject constructor(private val noteDao: NoteDao): NoteRepository{

    override fun getNotes(): Flow<List<NoteEntity>> = flow {
        noteDao.getAllNotes()
    }

    override suspend fun addNote(note: NoteEntity){
        noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note: NoteEntity){
        noteDao.deleteNote(note)
    }

    override suspend fun clearNote() {
        noteDao.clearNotes()
    }

    override fun searchNote(query: String): Flow<List<NoteEntity>> = flow {
        noteDao.searchNote(query)
    }
}