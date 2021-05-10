package com.example.mobilszoftverlabor.test

import com.example.mobilszoftverlabor.model.Note
import com.example.mobilszoftverlabor.model.ResponseMessage
import com.example.mobilszoftverlabor.testInjector
import com.example.mobilszoftverlabor.ui.addnote.AddNotePresenter
import com.example.mobilszoftverlabor.ui.addnote.AddNoteScreen
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
class AddNoteTest {
    @Inject
    lateinit var addNotePresenter: AddNotePresenter

    private lateinit var addNoteScreen: AddNoteScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        addNoteScreen = mock()
        addNotePresenter.attachScreen(addNoteScreen)
    }

    @Test
    fun testSaveNote() {
        val note = Note(
            "Test",
            "Test"
        )
        addNotePresenter.addNote(note)

        val item = argumentCaptor<ResponseMessage>()
        Mockito.verify(addNoteScreen).saveNote(item.capture())
        assert(item.value.message == "Note created")
    }

    @After
    fun tearDown() {
        addNotePresenter.detachScreen()
    }
}