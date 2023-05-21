package com.example.timelimitapp.ui.components


import android.app.Activity
import android.content.Intent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.timelimitapp.KioskManager
import com.example.timelimitapp.MainActivity

@Composable
fun ButtonCounter(maxCount:Int){
    val context = LocalContext.current
    val count = remember { mutableStateOf(0) }
    val isMaxCountReached = remember { mutableStateOf(false) }
    Button(onClick = {
        if(count.value < maxCount){
            count.value++
        }
        if(count.value>= maxCount){
            isMaxCountReached.value = true
        }
    }) {
        Text(text = "Click Me")
    }

    if(isMaxCountReached.value){
        KioskManager.stopKioskMode(context as Activity)
        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        context.startActivity(intent)
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    ButtonCounter(maxCount = 5)
}
