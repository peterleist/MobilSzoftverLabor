package com.example.mobilszoftverlabor.model

import java.util.*

data class Note (
    var title: String? = null,
    var content: String? = null,
    var createdAt: Date? = null,
    var updatedAt: Date? = null,
    )