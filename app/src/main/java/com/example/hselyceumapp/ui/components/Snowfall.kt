package com.example.hselyceumapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun Snowfall(isActive: Boolean) {
    var snowflakes by remember { mutableStateOf(listOf<Offset>()) }

    val fallDuration = 7000
    val addInterval = 300

    LaunchedEffect(isActive) {
        if (isActive) {
            while (true) {
                snowflakes = snowflakes + Offset(Random.nextFloat() * 700.dp.value, 0f)
                delay(addInterval.toLong())
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        for (snowflake in snowflakes) {
            Snowflake(snowflake, fallDuration)
        }
    }

    snowflakes = snowflakes.filter { it.y < 1000f }
}