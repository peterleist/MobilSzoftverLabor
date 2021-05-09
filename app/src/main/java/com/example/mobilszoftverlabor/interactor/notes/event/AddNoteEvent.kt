package com.example.mobilszoftverlabor.interactor.notes.event

import com.example.mobilszoftverlabor.model.ResponseMessage

data class AddNoteEvent(
    var code: Int = 0,
    var msg: ResponseMessage? = null,
    var throwable: Throwable? = null
)
