package com.ezadetoro.noteapp.Data

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Converter {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE

    // Converts a string from the database to a LocalDate.
    @TypeConverter
    fun fromString(value: String?): LocalDate? {
        return value?.let { LocalDate.parse(it, formatter) }
    }

    // Converts a LocalDate to a string for the database
    @TypeConverter
    fun dateToString(date: LocalDate?): String? {
        return date?.format(formatter)
    }
}