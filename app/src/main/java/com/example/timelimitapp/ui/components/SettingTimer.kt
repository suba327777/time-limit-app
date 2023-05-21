package com.example.timelimitapp.ui.components

import android.app.Activity
import android.app.TimePickerDialog
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timelimitapp.KioskActivity
import com.example.timelimitapp.KioskManager
import com.example.timelimitapp.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Calendar


@Composable
fun SettingTimer() {
    // var startTime by remember { mutableStateOf("") }
    // var endTime by remember { mutableStateOf("") }


    val mContext = LocalContext.current// Fetching local context
    val mCalendar = Calendar.getInstance()// Declaring and initializing a calendar
    val mHour = mCalendar[Calendar.HOUR_OF_DAY]
    val mMinute = mCalendar[Calendar.MINUTE]

    val startmTime = remember { mutableStateOf("") } // Creating a TimePicker dialod
    val endmTime = remember { mutableStateOf("") } // Creating a TimePicker dialod
    val startmTimePickerDialog = TimePickerDialog(
        mContext,
        { _, startHour: Int, startMinute: Int ->
            startmTime.value = "$startHour:$startMinute"
        }, mHour, mMinute, false
    )
    val endmTimePickerDialog = TimePickerDialog(
        mContext,
        { _, endHour: Int, endMinute: Int ->
            endmTime.value = "$endHour:$endMinute"
        }, mHour, mMinute, false
    )
    println(startmTime.value)
    println(endmTime.value)

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "開始時間", fontSize = 18.sp)

            // On button click, TimePicker is
            // displayed, user can select a time
            Button(
                onClick = { startmTimePickerDialog.show() },
                //colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))
            ) {
                Text(text = "Open Time Picker", color = Color.Black)
            }


            // Display selected time

            Text(text = "Selected Time: ${startmTime.value}", fontSize = 30.sp)
// Add a spacer of 100dp
            Spacer(modifier = Modifier.size(100.dp))

            Text(text = "終了時間", fontSize = 18.sp)
            Button(
                onClick = { endmTimePickerDialog.show() },
                //colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))
            ) {
                Text(text = "Open Time Picker", color = Color.Black)
            }


            // Display selected time

            Text(text = "Selected Time: ${endmTime.value}", fontSize = 30.sp)
            /*
                        TextField(
                            value = endTime,
                            onValueChange = { endTime = it },
                            modifier = Modifier
                                .width(80.dp)
                                .padding(vertical = 8.dp),
                        )
                        Button(
                            onClick = { /* ボタンがクリックされたときの処理を追加 */ },
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Text(text = "保存")
                        }

                         */

            val startmTimeSet = remember {
                mutableStateOf(false)
            }
            val endmTimeSet = remember{
                mutableStateOf(false)
            }

            //Run timer in the background
            //TODO startmTimeとendmTimeが同じ時に挙動がおかしくなる
            val coroutineScope = rememberCoroutineScope()
            LaunchedEffect(Unit){
                coroutineScope.launch {
                    while (true){
                        delay(1000)
                        // Check if it's time to activate or deactivate Kiosk mode
                        val currentTime = Calendar.getInstance()
                        val currentHour = currentTime.get(Calendar.HOUR_OF_DAY)
                        val currentMinute = currentTime.get(Calendar.MINUTE)

                        if (startmTime.value.isNotEmpty()&&endmTime.value.isNotEmpty()&&!startmTimeSet.value) {
                            // Check start time
                            val startTimeParts = startmTime.value.split(":")
                            val startHour = startTimeParts[0].toInt()
                            val startMinute = startTimeParts[1].toInt()

                            if (currentHour == startHour && currentMinute == startMinute) {
                                KioskManager.startKioskMode(mContext as Activity)
                                startmTimeSet.value = true
                                endmTimeSet.value = false

                                val intent = Intent(mContext,KioskActivity::class.java)
                                mContext.startActivity(intent)
                            }
                        }

                        if(startmTime.value.isNotEmpty()&&endmTime.value.isNotEmpty()&&!endmTimeSet.value){
                            val endTimeParts = endmTime.value.split(":")
                            val endHour = endTimeParts[0].toInt()
                            val endMinute = endTimeParts[1].toInt()

                            if (currentHour == endHour && currentMinute == endMinute) {
                                KioskManager.stopKioskMode(mContext as Activity)
                                endmTimeSet.value = true
                                startmTimeSet.value = false

                                val intent = Intent(mContext, MainActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                                mContext.startActivity(intent)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingTimerPreview() {
    SettingTimer()
}