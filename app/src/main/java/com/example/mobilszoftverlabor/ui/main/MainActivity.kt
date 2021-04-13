package com.example.mobilszoftverlabor.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobilszoftverlabor.R
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainScreen {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
    }

    override fun onStop() {
        mainPresenter.detachScreen()
        super.onStop()
    }

    override fun showNotes() {
        TODO("Not yet implemented")
    }
}