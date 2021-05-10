package com.example.mobilszoftverlabor.test

import com.example.mobilszoftverlabor.model.Note
import com.example.mobilszoftverlabor.model.NoteResult
import com.example.mobilszoftverlabor.model.ResponseMessage
import com.example.mobilszoftverlabor.testInjector
import com.example.mobilszoftverlabor.ui.notedetails.NoteDetailsPresenter
import com.example.mobilszoftverlabor.ui.notedetails.NoteDetailsScreen
import com.example.mobilszoftverlabor.utils.argumentCaptor
import com.example.mobilszoftverlabor.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import java.math.BigDecimal
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class NoteDetailsTest {
    @Inject
    lateinit var noteDetailsPresenter: NoteDetailsPresenter
    private lateinit var noteDetailsScreen: NoteDetailsScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        noteDetailsScreen = mock()
        noteDetailsPresenter.attachScreen(noteDetailsScreen)
    }

    @Test
    fun testGetNote() {
        noteDetailsPresenter.refreshNote(NOTE_ID)

        val item = argumentCaptor<NoteResult>()
        Mockito.verify(noteDetailsScreen).showNote(item.capture())
        assert(item.value.id == NOTE_ID)
        assert(item.value.title == NOTE_TITLE)
        assert(item.value.content == NOTE_CONTENT)
        assert(item.value.createdAt == NOTE_CREATEDAT)
        assert(item.value.updatedAt == NOTE_UPDATEDAT)
        assert(item.value.v == V)
    }

    @Test
    fun testDeleteNote() {
        val note = NoteResult("6065dde30927064ed860fb2e",
            "2021-05-09T17:52:15.973Z",
            "2021-05-09T17:52:15.973Z",
            "Test",
            "Test",
            BigDecimal(0)
        )
        noteDetailsPresenter.deleteNote(note)
        val item = argumentCaptor<ResponseMessage>()
        Mockito.verify(noteDetailsScreen).deleteNote(item.capture())
        assert(item.value.message == "Note deleted")
    }

    @Test
    fun testUpdateNote() {
        val note = Note(
            "Test",
            "Test"
        )
        noteDetailsPresenter.updateNote("6065dde30927064ed860fb2e", note)
        val item = argumentCaptor<ResponseMessage>()
        Mockito.verify(noteDetailsScreen).updateNote(item.capture())
        assert(item.value.message == "Note updated")
    }

    @After
    fun tearDown() {
        noteDetailsPresenter.detachScreen()
    }

    companion object {
        private const val NOTE_ID = "6065dde30927064ed860fb2e"
        private const val NOTE_TITLE = "Test"
        private const val NOTE_CONTENT = "Test"
        private const val NOTE_CREATEDAT = "2021-05-09T17:52:15.973Z"
        private const val NOTE_UPDATEDAT = "2021-05-09T17:52:15.973Z"
        private val V = BigDecimal(0)
    }
}