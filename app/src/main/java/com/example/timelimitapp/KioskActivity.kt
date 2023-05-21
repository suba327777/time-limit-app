package com.example.timelimitapp

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text

class KioskActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val startmTime = intent.getStringExtra("startmTime")
        val endmTime = intent.getStringExtra("endmTime")

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                //挙動無効化のためnone
            }
        }

        setTheme(R.style.WhiteTheme)
        setContent {
            Column() {
                Text(text = "${startmTime}~${endmTime}")
            }
        }

        onBackPressedDispatcher.addCallback(this,callback)

    }

}