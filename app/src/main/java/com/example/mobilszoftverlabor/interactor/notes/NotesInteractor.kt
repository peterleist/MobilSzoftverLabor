package com.example.mobilszoftverlabor.interactor.notes

import com.example.mobilszoftverlabor.network.NoteApi
import javax.inject.Inject

class NotesInteractor @Inject constructor(private var noteApi: NoteApi) {
    fun getNotes(){}
}