package com.ezadetoro.noteapp.Data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.Date

@Entity(tableName = "notes_table")
data class NoteEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // Default to 0 for auto-generation
    val title: String,
    val noteContent: String,
    val createAt: LocalDate,
    val edittedAt: Date? = null
)
