package com.example.mobilszoftverlabor.interactor

import androidx.room.Dao
import com.example.mobilszoftverlabor.data.NoteDAO
import com.example.mobilszoftverlabor.interactor.notes.NotesInteractor
import com.example.mobilszoftverlabor.network.NoteApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideNotesInteractor(notesApi: NoteApi, noteDao: NoteDAO) = NotesInteractor(notesApi, noteDao)
}