package com.example.timelimitapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text

class KioskActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val startmTime = intent.getStringExtra("startmTime")
        val endmTime = intent.getStringExtra("endmTime")
        setContent {
            Column() {
                Text(text = "${startmTime}~${endmTime}")
            }
        }
    }
}