package com.example.mobilszoftverlabor.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    companion object {
        private const val DB_NAME = "notes.db"
    }

    @Provides
    @Singleton
    fun provideNoteDao(db: AppDatabase): NoteDAO = db.noteDao()

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}