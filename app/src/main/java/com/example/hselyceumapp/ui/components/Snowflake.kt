package com.example.hselyceumapp.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.hselyceumapp.R

@Composable
fun Snowflake(position: Offset, fallDuration: Int) {
    val snowflakeImage: Painter = painterResource(id = R.drawable.snowflake)

    val yOffset = remember { Animatable(position.y) }

    LaunchedEffect(position) {
        yOffset.animateTo(
            targetValue = 900f,
            animationSpec = tween(durationMillis = fallDuration)
        )
    }

    Image(
        painter = snowflakeImage,
        contentDescription = null,
        modifier = Modifier
            .offset(x = position.x.dp, y = yOffset.value.dp)
            .size(10.dp)
    )
}