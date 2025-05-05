package com.ezadetoro.noteapp.Data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface NoteDao {
    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    @Delete
    suspend fun deleteNote(note: NoteEntity)

    @Query("DELETE FROM notes_table")
    suspend fun clearNotes()

    @Query("SELECT * FROM notes_table WHERE title LIKE '%' || :searchQuery || '%' OR noteContent LIKE '%' || :searchQuery || '%' ")
    fun searchNote(searchQuery: String): Flow<List<NoteEntity>>

}