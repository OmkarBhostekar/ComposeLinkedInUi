package com.omkarcodes.composelinkedinui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    }
}

@Preview
@Composable
fun Preview() {
    HomeScreen()
}
