package com.ezadetoro.noteapp.repository

import com.ezadetoro.noteapp.Data.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(): Flow<List<NoteEntity>>
    suspend fun addNote(note: NoteEntity)
    suspend fun deleteNote(note: NoteEntity)
    suspend fun clearNote()
    fun searchNote(query: String): Flow<List<NoteEntity>>
}