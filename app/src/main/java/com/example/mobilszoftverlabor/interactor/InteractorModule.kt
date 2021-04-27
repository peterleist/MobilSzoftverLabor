package com.example.mobilszoftverlabor.interactor

import com.example.mobilszoftverlabor.interactor.notes.NotesInteractor
import com.example.mobilszoftverlabor.network.NoteApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideAppointmentsInteractor(notesApi: NoteApi) = NotesInteractor(notesApi)
}