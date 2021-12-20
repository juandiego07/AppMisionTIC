package com.misiontic.touristicsites.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.misiontic.touristicsites.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)
    }
}