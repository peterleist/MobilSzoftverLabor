package com.example.mobilszoftverlabor.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "note")
data class Note (

    @SerializedName("id")
    @PrimaryKey
    var _id: String? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("content")
    var content: String? = null,

    @SerializedName("createdAt")
    @ColumnInfo(name = "createDate")
    var createdAt: Date? = null,

    @SerializedName("updatedAt")
    @ColumnInfo(name = "updateDate")
    var updatedAt: Date? = null,

    @SerializedName("__v")
    @ColumnInfo(name = "version")
    @Ignore
    var __v: Int? = null,
    )