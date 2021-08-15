package com.omkarcodes.composelinkedinui.models

data class Post(
    val user: User,
    val text: String,
    val image: Int,
    val likes: Int,
    val comments: Int,
    val timestamp: String,
    val reactions: List<Int>,
    val followingReaction: FollowingReaction? = null
)

data class FollowingReaction(
    val name: String,
    val reaction: String
)
