package com.example.mobilszoftverlabor.interactor

import com.example.mobilszoftverlabor.interactor.notes.NotesInteractor
import com.example.mobilszoftverlabor.network.NotesAPI
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideAppointmentsInteractor(notesApi: NotesAPI) = NotesInteractor(notesApi)
}