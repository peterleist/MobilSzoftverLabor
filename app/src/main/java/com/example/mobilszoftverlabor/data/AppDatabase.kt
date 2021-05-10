package com.example.mobilszoftverlabor.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mobilszoftverlabor.model.Note
import com.example.mobilszoftverlabor.model.NoteResult

@Database(entities = [NoteResult::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDAO
}