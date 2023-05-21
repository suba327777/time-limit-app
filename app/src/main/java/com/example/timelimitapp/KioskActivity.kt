package com.example.timelimitapp

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import com.example.timelimitapp.ui.components.ButtonCounter
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timelimitapp.ui.theme.TimeLimitAppTheme


class KioskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.hide()

        val startmTime = intent.getStringExtra("startmTime")
        val endmTime = intent.getStringExtra("endmTime")

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                //挙動無効化のためnone
            }
        }

        setTheme(R.style.WhiteTheme)
        setContent {
            TimeLimitAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.size(300.dp))
                        Text(text = "${startmTime}~${endmTime}", fontSize = 30.sp)
                        ButtonCounter(maxCount = 10000)
                    }
                }

            }
        }
        onBackPressedDispatcher.addCallback(this, callback)

    }

}

