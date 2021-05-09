package com.example.mobilszoftverlabor.interactor.notes.event

import com.example.mobilszoftverlabor.model.ResponseMessage

data class DeleteNoteEvent(
    var code: Int = 0,
    var msg: ResponseMessage? = null,
    var throwable: Throwable? = null
)
