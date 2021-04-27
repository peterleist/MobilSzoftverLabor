package com.example.mobilszoftverlabor.model

import com.google.gson.annotations.SerializedName

data class NotesResult(
    @SerializedName("notes")
    var notes: Note? = null
)
