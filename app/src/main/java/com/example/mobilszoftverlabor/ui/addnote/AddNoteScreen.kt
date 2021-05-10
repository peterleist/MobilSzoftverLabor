package com.example.mobilszoftverlabor.ui.addnote

import com.example.mobilszoftverlabor.model.ResponseMessage

interface AddNoteScreen {
    fun saveNote(msg: ResponseMessage?)
    fun showError(errorMsg: String)
}