package com.example.timelimitapp.ui.components
import android.app.TimePickerDialog
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingTimerPreview() {
    SettingTimer()
}