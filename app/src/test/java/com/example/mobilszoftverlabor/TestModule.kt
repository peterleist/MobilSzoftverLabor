package com.example.mobilszoftverlabor

import android.content.Context
import com.example.mobilszoftverlabor.interactor.notes.NotesInteractor
import com.example.mobilszoftverlabor.ui.addnote.AddNotePresenter
import com.example.mobilszoftverlabor.ui.main.MainPresenter
import com.example.mobilszoftverlabor.ui.notedetails.NoteDetailsPresenter
import com.example.mobilszoftverlabor.utils.UiExecutor
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {

    @Provides
    fun provideContext() = context

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
    fun provideNetworkExecutor(): Executor = UiExecutor()
}