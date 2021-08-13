package com.omkarcodes.composelinkedinui.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omkarcodes.composelinkedinui.HomeScreen
import com.omkarcodes.composelinkedinui.Post
import com.omkarcodes.composelinkedinui.User

@Composable
fun PostItem(post: Post) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(Color(0xFFE8E6DE))
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                    pushStyle(boldStyle)
                    append("Raj Vikramaditya")
                    pop()
                    append(" commented on this")
                },
                fontSize = 14.sp
            )
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )
        }
        Divider(
            thickness = 0.8.dp,
            color = Color.LightGray,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        UserInfo(post.user)
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = post.text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            maxLines = 5,
            overflow = TextOverflow.Ellipsis,
            fontSize = 14.sp,
            color = Color.Black,
            textAlign = TextAlign.Justify
        )
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(post.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
        )
        Spacer(modifier = Modifier.height(5.dp))
        LikesAndCommentsCount(likes = post.likes, comments = post.comments)
    }
}

@Composable
fun UserInfo(user: User) {
    Row(
        verticalAlignment =Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp,)
    ) {
        Image(
            painter = painterResource(id = user.profile),
            contentDescription = null,
            modifier = Modifier
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .size(40.dp)
                .weight(1.4f)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .weight(8.5f)
                .padding(start = 15.dp)
        ) {
            Text(
                text = buildAnnotatedString {
                    pushStyle(
                        SpanStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.SemiBold,
                        )
                    )
                    append(user.username)
                    pop()
                    append(" \u2022 Following")
                },
                fontSize = 14.sp
            )
            Text(
                text = user.description,
                color = Color.Gray,
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp
            )
            Text(
                text = "2h",
                color = Color.Gray,
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp
            )
        }
    }
}

@Composable
fun LikesAndCommentsCount(likes: Int, comments: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    HomeScreen()
}