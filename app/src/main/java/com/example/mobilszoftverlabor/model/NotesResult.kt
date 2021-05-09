package com.example.mobilszoftverlabor.model

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class NotesResult(
    @SerializedName("notes")
    var notes: MutableList<NoteResult> = ArrayList()
)
