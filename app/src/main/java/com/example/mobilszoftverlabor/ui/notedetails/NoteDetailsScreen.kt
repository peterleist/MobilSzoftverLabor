package com.example.mobilszoftverlabor.ui.notedetails

import com.example.mobilszoftverlabor.model.NoteResult
import com.example.mobilszoftverlabor.model.ResponseMessage

interface NoteDetailsScreen {
    fun showNote( note: NoteResult?)
    fun updateNote(msg: ResponseMessage?)
    fun deleteNote(msg: ResponseMessage?)
    fun showError(errorMsg: String)
}