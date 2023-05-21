package com.example.timelimitapp

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import com.example.timelimitapp.ui.components.ButtonCounter
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "${startmTime}~${endmTime}",fontSize = 30.sp)
                ButtonCounter(maxCount = 5)
            }
        }

        onBackPressedDispatcher.addCallback(this,callback)

    }

}

