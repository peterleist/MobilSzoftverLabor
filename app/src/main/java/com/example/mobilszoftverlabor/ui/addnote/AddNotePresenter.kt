package com.example.mobilszoftverlabor.ui.addnote

import com.example.mobilszoftverlabor.interactor.notes.NotesInteractor
import com.example.mobilszoftverlabor.interactor.notes.event.AddNoteEvent
import com.example.mobilszoftverlabor.model.Note
import com.example.mobilszoftverlabor.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class AddNotePresenter @Inject constructor(private val executor: Executor, private val notesInteractor: NotesInteractor): Presenter<AddNoteScreen>() {

    override fun attachScreen(screen: AddNoteScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }


    fun addNote(note: Note){
        executor.execute{
            notesInteractor.addNote(note)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: AddNoteEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.msg != null) {
                    screen?.saveNote()
                }

            }
        }
    }
}