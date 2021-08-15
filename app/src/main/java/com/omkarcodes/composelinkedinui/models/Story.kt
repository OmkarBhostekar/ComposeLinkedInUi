package com.omkarcodes.composelinkedinui.models

import androidx.compose.ui.graphics.painter.Painter

data class Story(
    val image: Painter,
    val text: String,
    val seen: Boolean = false,
)
