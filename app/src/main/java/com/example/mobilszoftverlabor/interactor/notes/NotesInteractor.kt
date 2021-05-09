package com.example.mobilszoftverlabor.interactor.notes

import android.util.Log
import com.example.mobilszoftverlabor.data.NoteDAO
import com.example.mobilszoftverlabor.interactor.notes.event.*
import com.example.mobilszoftverlabor.model.Note
import com.example.mobilszoftverlabor.model.NoteResult
import com.example.mobilszoftverlabor.network.NoteApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class NotesInteractor @Inject constructor(private var noteApi: NoteApi, private var noteDao: NoteDAO) {
    fun getNotes(){
        val event = GetNotesEvent()

        try {
            val notesCall = noteApi.notes

            val response = notesCall.execute()

            Log.d("Reponse", response.body().toString())

            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()

            val apiNotes = response.body()
            var notes = noteDao.getNotes()
            if(apiNotes != null){
                if(!notes.containsAll(apiNotes)){
                    noteDao.insertNotes(apiNotes)
                    notes = noteDao.getNotes()
                }
            }
            event.notes = notes
            EventBus.getDefault().post(event)
        }
            catch (e: Exception) {
                event.throwable = e
                EventBus.getDefault().post(event)
    }
    }

    fun getNote(id: String){
        val event = GetNoteEvent()

        try {
            val notesCall = noteApi.getNoteNoteid(id)

            val response = notesCall.execute()

            Log.d("Reponse", response.body().toString())

            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.note = response.body()
            EventBus.getDefault().post(event)
        }
        catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun saveNote(id: String?, note: Note){
        val event = SaveNoteEvent()

        try {
            val notesCall = noteApi.putNoteUpdateNoteid(id, note)

            val response = notesCall.execute()

            Log.d("Reponse", response.body().toString())

            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.msg = response.body()
            EventBus.getDefault().post(event)
        }
        catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun addNote(note: Note){
        val event = AddNoteEvent()

        try {
            val notesCall = noteApi.postNoteCreate(note)

            val response = notesCall.execute()

            Log.d("Reponse", response.body().toString())

            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.msg = response.body()
            EventBus.getDefault().post(event)
        }
        catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun deleteNote(note: NoteResult){
        val event = DeleteNoteEvent()

        try {
            val notesCall = noteApi.deleteNoteDeleteNoteid(note.id)
            val response = notesCall.execute()
            Log.d("Reponse", response.body().toString())

            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.msg = response.body()
            noteDao.deleteNote(note)
            EventBus.getDefault().post(event)
        }
        catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }
}