package com.example.mobilszoftverlabor.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mobilszoftverlabor.model.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDAO
}