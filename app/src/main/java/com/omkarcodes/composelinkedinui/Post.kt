package com.omkarcodes.composelinkedinui

data class Post(
    val user: User,
    val text: String,
    val image: Int,
    val likes: Int,
    val comments: Int,
)
