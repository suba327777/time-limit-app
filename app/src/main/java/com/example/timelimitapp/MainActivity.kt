package com.example.timelimitapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.timelimitapp.ui.components.SettingTimer


import com.example.timelimitapp.ui.components.TextSample
import com.example.timelimitapp.ui.theme.TimeLimitAppTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.hide()

        setTheme(R.style.WhiteTheme)
        setContent {
            TimeLimitAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {

                    SettingTimer()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        KioskManager.isAdmin(this)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TimeLimitAppTheme {
        TextSample("Android")
    }
}

