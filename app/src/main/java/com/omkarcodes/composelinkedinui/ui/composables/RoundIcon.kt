package com.omkarcodes.composelinkedinui.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp


@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 2.dp,
                color = Color(0xFF7E57C2),
                shape = CircleShape
            )
            .padding(4.dp)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape)
            .clip(CircleShape)
    )
}
