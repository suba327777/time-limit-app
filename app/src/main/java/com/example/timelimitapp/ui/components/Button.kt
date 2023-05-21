package com.example.timelimitapp.ui.components


import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.timelimitapp.KioskManager
import com.example.timelimitapp.MainActivity

@Composable
fun ButtonCounter(maxCount: Int) {
    val context = LocalContext.current
    val count = remember { mutableStateOf(0) }
    val isMaxCountReached = remember { mutableStateOf(false) }

    if (isMaxCountReached.value) {
        KioskManager.stopKioskMode(context as Activity)
        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        context.startActivity(intent)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                if (count.value < maxCount) {
                    count.value++
                }
                if (count.value >= maxCount) {
                    isMaxCountReached.value = true
                }
            }, modifier = Modifier.size(width = 200.dp, height = 50.dp)
        )
        {
            Text(text = "Click Me")
        }
        Spacer(modifier = Modifier.size(50.dp))
        val progress = (count.value.toFloat() / maxCount.toFloat())
        ProgressBar(progress = progress)
    }

}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    ButtonCounter(maxCount = 5)
}
