package com.example.mobilszoftverlabor.mock

import android.content.Context
import androidx.room.Room
import com.example.mobilszoftverlabor.data.AppDatabase
import com.example.mobilszoftverlabor.data.NoteDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockDatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java).build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(db: AppDatabase): NoteDAO = MockNoteDAO()
}