package com.example.timelimitapp.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp


@Composable
fun ProgressBar(progress:Float) {
    LinearProgressIndicator(
        progress = progress,
        modifier = Modifier.size(width = 250.dp, height = 40.dp)
            .clip(RoundedCornerShape(8.dp))
    )

}