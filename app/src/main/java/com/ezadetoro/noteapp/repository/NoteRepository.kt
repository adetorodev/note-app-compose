package com.ezadetoro.noteapp.repository

import com.ezadetoro.noteapp.Data.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(): Flow<List<NoteEntity>>
    suspend fun addNote(note: NoteEntity)
    suspend fun update(note: NoteEntity)
    suspend fun noteDetail(id: Int)
    suspend fun deleteNote(id: Int)
    suspend fun clearNote()
    fun searchNote(query: String): Flow<List<NoteEntity>>
}