/*
 * Note
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package com.example.mobilszoftverlabor.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import javax.annotation.Generated

@Generated(
    value = ["io.swagger.codegen.v3.generators.java.JavaClientCodegen"],
    date = "2021-04-27T19:36:05.724396400+02:00[Europe/Prague]"
)
@Entity(tableName = "note")
data class NoteResult (

    @SerializedName("_id")
    var id: String? = null,

    @SerializedName("updatedAt")
    var updatedAt: String? = null,

    @SerializedName("createdAt")
    var createdAt: String? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("content")
    var content: String? = null,

    @SerializedName("__v")
    var v: BigDecimal? = null,

    )