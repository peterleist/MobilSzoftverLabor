package com.example.mobilszoftverlabor.mock


import com.example.mobilszoftverlabor.model.Note
import com.example.mobilszoftverlabor.model.NoteResult
import com.example.mobilszoftverlabor.model.ResponseMessage
import com.example.mobilszoftverlabor.network.NoteApi
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Path
import java.io.IOException
import java.math.BigDecimal

class MockNotesAPI() : NoteApi{

    override fun deleteNoteDeleteNoteid(
        @Path("noteid") noteid: String?): Call<ResponseMessage?> {
        val deleteResponse = ResponseMessage("Note deleted")
        return object : Call<ResponseMessage?> {
            @Throws(IOException::class)
            override fun execute(): Response<ResponseMessage?> {
                return Response.success(deleteResponse)
            }

            override fun enqueue(callback: Callback<ResponseMessage?>) {}

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {}

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<ResponseMessage?> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }
    }

    override fun getNoteNoteid(@Path("noteid") noteid: String?): Call<NoteResult?> {
        val note = NoteResult("6065dde30927064ed860fb2e",
            "2021-05-09T17:52:15.973Z",
            "2021-05-09T17:52:15.973Z",
            "Test",
            "Test",
            BigDecimal(0)
        )

        val call = object : Call<NoteResult?> {
            @Throws(IOException::class)
            override fun execute(): Response<NoteResult?> {
                return Response.success(note)
            }

            override fun enqueue(callback: Callback<NoteResult?>) {}

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {}

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<NoteResult?> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }

    override val notes: Call<List<NoteResult>>
        get() {
            val noteList = listOf(
                NoteResult("6065dde30927064ed860fb2e",
                    "2021-05-09T17:52:15.973Z",
                    "2021-05-09T17:52:15.973Z",
                    "Test",
                    "Test",
                    BigDecimal(0)

                ))

            return object : Call<List<NoteResult>> {
                @Throws(IOException::class)
                override fun execute(): Response<List<NoteResult>?> {
                    return Response.success<List<NoteResult>>(noteList)
                }

                override fun enqueue(callback: Callback<List<NoteResult>?>) {}

                override fun isExecuted(): Boolean {
                    return false
                }

                override fun cancel() {}

                override fun isCanceled(): Boolean {
                    return false
                }

                override fun clone(): Call<List<NoteResult>> {
                    return this
                }

                override fun request(): Request? {
                    return null
                }
            }
        }

    override fun postNoteCreate(@Body body: Note?): Call<ResponseMessage?> {
        val note = NoteResult("6065dde30927064ed860fb2e",
            "2021-05-09T17:52:15.973Z",
            "2021-05-09T17:52:15.973Z",
            "Test",
            "Test",
            BigDecimal(0)
        )
        return object : Call<ResponseMessage?> {
            @Throws(IOException::class)
            override fun execute(): Response<ResponseMessage?> {
                return Response.success<ResponseMessage>(ResponseMessage("Note created"))
            }

            override fun enqueue(callback: Callback<ResponseMessage?>) {}

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {}

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<ResponseMessage?> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }
    }

    override fun putNoteUpdateNoteid(@Path("noteid") noteid: String?, @Body body: Note?): Call<ResponseMessage?> {
        val note = NoteResult("6065dde30927064ed860fb2e",
            "2021-05-09T17:52:15.973Z",
            "2021-05-09T17:52:15.973Z",
            "Test",
            "Test",
            BigDecimal(0)
        )
        return object : Call<ResponseMessage?> {
            @Throws(IOException::class)
            override fun execute(): Response<ResponseMessage?> {
                return Response.success<ResponseMessage>(ResponseMessage("Note updated"))
            }

            override fun enqueue(callback: Callback<ResponseMessage?>) {}

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {}

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<ResponseMessage?> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }
    }
}