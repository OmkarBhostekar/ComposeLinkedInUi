package com.omkarcodes.composelinkedinui.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omkarcodes.composelinkedinui.Story

@Composable
fun StorySection(
    stories: List<Story>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
    ){
        items(stories.size){
            if (it == 0)
                YourStory(story = stories[it])
            else
                StoryView(story = stories[it])
        }
    }
}

@Composable
fun YourStory(
    story: Story
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        Box(
            modifier = Modifier.size(65.dp)
        ) {
            Image(
                painter = story.image,
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .aspectRatio(1f, matchHeightConstraintsFirst = true)
                    .clip(CircleShape)
                    .align(Alignment.Center)
            )
            FloatingActionButton(
                onClick = {  },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(24.dp)
                    .shadow(elevation = 0.dp),
                backgroundColor = Color.White
            ) {
                Text(text = "+")
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = story.text,
            fontSize = 12.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun StoryView(
    story: Story
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 8.dp)
    ) {
        RoundImage(
            image = story.image,
            modifier = Modifier.size(65.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = story.text,
            fontSize = 12.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
    }
}
