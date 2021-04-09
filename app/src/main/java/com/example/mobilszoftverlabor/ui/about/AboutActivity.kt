package com.example.mobilszoftverlabor.ui.about

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilszoftverlabor.R
import javax.inject.Inject

class AboutActivity: AppCompatActivity(), AboutScreen {

    @Inject
    lateinit var aboutPresenter: AboutPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

}