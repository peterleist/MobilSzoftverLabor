package com.example.mobilszoftverlabor.test

import com.example.mobilszoftverlabor.model.NoteResult
import com.example.mobilszoftverlabor.testInjector
import com.example.mobilszoftverlabor.ui.main.MainPresenter
import com.example.mobilszoftverlabor.ui.main.MainScreen
import com.example.mobilszoftverlabor.utils.argumentCaptor
import com.example.mobilszoftverlabor.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class MainTest {
    @Inject
    lateinit var mainPresenter: MainPresenter

    private lateinit var mainScreen: MainScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        mainScreen = mock()
        mainPresenter.attachScreen(mainScreen)
    }

    @Test
    fun testGetNotes() {
        mainPresenter.refreshNotes()
        val list = argumentCaptor<MutableList<NoteResult>>()
        verify(mainScreen).showNotes(list.capture())
        assert(list.value.size > 0)
    }


    @After
    fun tearDown() {
        mainPresenter.detachScreen()
    }

}