package com.example.mobilszoftverlabor.model

import com.google.gson.annotations.SerializedName

data class Response (
    @SerializedName("message")
    var message: String? = null
)