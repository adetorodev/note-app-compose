package com.ezadetoro.noteapp.Data

import java.time.LocalDate
import java.util.Date

data class Note(
    val id: Int? = null,
    val title: String,
    val noteContent: String,
    val createAt: LocalDate,
    val edittedAt: Date? = null
)

val noteList: List<Note> = listOf(
    Note(1, "Meeting", "Plan weekly meeting agenda", LocalDate.now() ),
    Note(2, "Shopping", "Plan weekly meeting agenda list milk, eggs, bread, and eggs", LocalDate.now() ),
    Note(3, "Work Tasks", "Plan weekly meeting agenda finish report and send email", LocalDate.now() ),
    Note(4, "Travel Plans", "Plan weekly meeting agenda book flight ticket", LocalDate.now() ),

)