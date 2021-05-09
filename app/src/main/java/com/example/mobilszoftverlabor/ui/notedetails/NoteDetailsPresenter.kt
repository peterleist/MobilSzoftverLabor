package com.example.mobilszoftverlabor.ui.notedetails

import com.example.mobilszoftverlabor.interactor.notes.NotesInteractor
import com.example.mobilszoftverlabor.interactor.notes.event.GetNoteEvent
import com.example.mobilszoftverlabor.interactor.notes.event.GetNotesEvent
import com.example.mobilszoftverlabor.model.Note
import com.example.mobilszoftverlabor.model.NoteResult
import com.example.mobilszoftverlabor.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class NoteDetailsPresenter @Inject constructor(private val executor: Executor, private val notesInteractor: NotesInteractor): Presenter<NoteDetailsScreen>() {
    override fun attachScreen(screen: NoteDetailsScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun refreshNote(id: String) {
        executor.execute {
            notesInteractor.getNote(id)
        }
    }

    fun updateNote(id: String, note: Note){
        executor.execute{
            notesInteractor.saveNote(id, note)
        }
    }

    fun deleteNote(note: NoteResult){
        executor.execute{
            notesInteractor.deleteNote(note)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetNoteEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.note != null) {
                    screen?.showNote(event.note as NoteResult)
                }

            }
        }
    }
}