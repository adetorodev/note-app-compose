package com.ezadetoro.noteapp.Data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false )
@TypeConverters(Converter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}