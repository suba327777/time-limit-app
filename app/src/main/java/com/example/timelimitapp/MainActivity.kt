package com.example.timelimitapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
//import com.example.timelimitapp.ui.components.SettingTimer


import com.example.timelimitapp.ui.components.TextSample
import com.example.timelimitapp.ui.theme.TimeLimitAppTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimeLimitAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   TextSample(name = "Android")
                    //SettingTimer()
                    TextSample(name = "Android")
                    //仮のbutton
                    /*Button(onClick ={KioskManager.setKioskMode(this)} ){
                        Text(text = "kioskMode")
                    }*/
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

