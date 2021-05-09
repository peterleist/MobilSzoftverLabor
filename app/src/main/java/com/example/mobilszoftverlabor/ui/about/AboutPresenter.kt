package com.example.mobilszoftverlabor.ui.about

import com.example.mobilszoftverlabor.interactor.notes.NotesInteractor
import com.example.mobilszoftverlabor.ui.Presenter
import java.util.concurrent.Executor
import javax.inject.Inject

class AboutPresenter @Inject constructor(private val executor: Executor, private val notesInteractor: NotesInteractor): Presenter<AboutScreen>() {
}