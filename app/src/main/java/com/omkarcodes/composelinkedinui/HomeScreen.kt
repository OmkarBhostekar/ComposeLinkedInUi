package com.omkarcodes.composelinkedinui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omkarcodes.composelinkedinui.ui.composables.PostItem
import com.omkarcodes.composelinkedinui.ui.composables.StorySection
import com.omkarcodes.composelinkedinui.ui.composables.TopBar

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        TopBar(
            image = painterResource(id = R.drawable.me)
        )
        Spacer(modifier = Modifier.height(15.dp))
        StorySection(
            stories = listOf(
                Story(image = painterResource(id = R.drawable.me),"Your Story",),
                Story(image = painterResource(id = R.drawable.amazon),"Amazon",),
                Story(image = painterResource(id = R.drawable.codechef),"CodeChef",),
                Story(image = painterResource(id = R.drawable.google),"Google",),
                Story(image = painterResource(id = R.drawable.swiggy),"Swiggy",),
                Story(image = painterResource(id = R.drawable.amazon),"Amazon",),
                Story(image = painterResource(id = R.drawable.codechef),"CodeChef",),
                Story(image = painterResource(id = R.drawable.google),"Google",),
                Story(image = painterResource(id = R.drawable.swiggy),"Swiggy",),
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Posts()
    }
}

@Composable
fun Posts() {
    val posts = listOf(
        Post(
            user = User("Amazon","E-Commerce MNC", R.drawable.amazon),
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
            image = R.drawable.amazon,
            likes = 1024,
            comments = 246
        ),
        Post(
            user = User("Google","Google", R.drawable.google),
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
            image = R.drawable.google,
            likes = 1520,
            comments = 347
        ),
        Post(
            user = User("Swiggy","Indian Food Giant", R.drawable.swiggy),
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
            image = R.drawable.swiggy,
            likes = 956,
            comments = 195
        ),
        Post(
            user = User("CodeChef","Coding Challanges", R.drawable.codechef),
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
            image = R.drawable.codechef,
            likes = 543,
            comments = 85
        ),
    )
    LazyColumn {
        items(posts.size){
            PostItem(post = posts[it])
        }
    }
}

@Preview
@Composable
fun Preview() {
    HomeScreen()
}
