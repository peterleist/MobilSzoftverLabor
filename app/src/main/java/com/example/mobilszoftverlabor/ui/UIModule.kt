package com.example.mobilszoftverlabor.ui

import android.content.Context
import com.example.mobilszoftverlabor.interactor.notes.NotesInteractor
import com.example.mobilszoftverlabor.ui.about.AboutPresenter
import com.example.mobilszoftverlabor.ui.addnote.AddNotePresenter
import com.example.mobilszoftverlabor.ui.main.MainPresenter
import com.example.mobilszoftverlabor.ui.notedetails.NoteDetailsPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun mainPresenter(executor: Executor, notesInteractor: NotesInteractor) = MainPresenter(executor, notesInteractor)

    @Provides
    @Singleton
    fun noteDetailsPresenter(executor: Executor, notesInteractor: NotesInteractor) = NoteDetailsPresenter(executor, notesInteractor)

    @Provides
    @Singleton
    fun addNotePresenter(executor: Executor, notesInteractor: NotesInteractor) = AddNotePresenter(executor, notesInteractor)

    @Provides
    @Singleton
    fun aboutPresenter(executor: Executor, notesInteractor: NotesInteractor) = AboutPresenter(executor, notesInteractor)

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)
}