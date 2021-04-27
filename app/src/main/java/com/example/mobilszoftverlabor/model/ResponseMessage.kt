package com.example.mobilszoftverlabor.model

import com.google.gson.annotations.SerializedName

data class ResponseMessage(
    @SerializedName("message")
    var message: String? = null
)
