package com.ezadetoro.noteapp.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes_table ORDER BY createAt DESC")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    @Update
    suspend fun updateNote(note: NoteEntity)

    @Query("SELECT * FROM notes_table WHERE id = :id")
    suspend fun noteDetail(id: Int): NoteEntity

    @Query("DELETE FROM notes_table WHERE id = :id")
    suspend fun deleteNote(id: Int)

    @Query("DELETE FROM notes_table")
    suspend fun clearNotes()

    @Query("SELECT * FROM notes_table WHERE title LIKE '%' || :searchQuery || '%' OR noteContent LIKE '%' || :searchQuery || '%' ")
    fun searchNote(searchQuery: String): Flow<List<NoteEntity>>

}