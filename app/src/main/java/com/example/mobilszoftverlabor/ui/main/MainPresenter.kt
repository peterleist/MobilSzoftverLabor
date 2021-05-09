package com.example.mobilszoftverlabor.ui.main

import com.example.mobilszoftverlabor.interactor.notes.NotesInteractor
import com.example.mobilszoftverlabor.interactor.notes.event.GetNotesEvent
import com.example.mobilszoftverlabor.model.NoteResult
import com.example.mobilszoftverlabor.model.NotesResult
import com.example.mobilszoftverlabor.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class MainPresenter @Inject constructor(private val executor: Executor, private val notesInteractor: NotesInteractor) : Presenter<MainScreen>() {

    override fun attachScreen(screen: MainScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun refreshNotes() {
        executor.execute {
            notesInteractor.getNotes()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetNotesEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.notes != null) {
                    screen?.showNotes(event.notes as MutableList<NoteResult>)
                }
            }
        }
    }

}