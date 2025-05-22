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

    override suspend fun update(note: NoteEntity) {
        noteDao.updateNote(note)
    }

    override suspend fun noteDetail(id: Int) {
        noteDao.noteDetail(id)
    }

    override suspend fun deleteNote(id: Int){
        noteDao.deleteNote(id)
    }

    override suspend fun clearNote() {
        noteDao.clearNotes()
    }

    override fun searchNote(query: String): Flow<List<NoteEntity>> = flow {
        noteDao.searchNote(query)
    }
}