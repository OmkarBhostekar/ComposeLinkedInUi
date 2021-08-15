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
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Share

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omkarcodes.composelinkedinui.ui.screens.HomeScreen
import com.omkarcodes.composelinkedinui.models.Post
import com.omkarcodes.composelinkedinui.models.User
import com.omkarcodes.composelinkedinui.ui.theme.myGray
import com.omkarcodes.composelinkedinui.R
import com.omkarcodes.composelinkedinui.models.FollowingReaction

@Composable
fun PostItem(post: Post) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .background(Color(0xFFE8E6DE))
        )
        post.followingReaction?.let {
            FollowingReaction(it)
        }
        Divider(
            thickness = 0.8.dp,
            color = Color.LightGray,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        UserInfo(post.user,post.timestamp,post.followingReaction)
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
        val image = painterResource(id = post.image)
        val ratio = image.intrinsicSize.width / image.intrinsicSize.height
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = ratio),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(5.dp))
        LikesAndCommentsCount(likes = post.likes, comments = post.comments, reactions = post.reactions)
    }
}

@Composable
fun FollowingReaction(followingReaction: FollowingReaction) {
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
                append(followingReaction.name)
                pop()
                append(" ${followingReaction.reaction}")
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
}

@Composable
fun UserInfo(user: User,timestamp: String,followingReaction: FollowingReaction? = null) {
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
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = timestamp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium,
                    fontSize = 11.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Image(
                    painter = painterResource(id = R.drawable.earth),
                    contentDescription = null,
                    modifier = Modifier.size(9.dp)
                )
            }
        }
        if (followingReaction == null){
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun LikesAndCommentsCount(likes: Int, comments: Int, reactions: List<Int>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 5.dp, start = 5.dp, end = 5.dp)
        ) {
            Row {
                reactions.forEach {
                    Image(
                        painter = painterResource(id = it),
                        contentDescription = null,
                        modifier = Modifier
                            .size(14.dp)
                    )
                    Spacer(Modifier.width(2.dp))
                }
                Text(
                    text = likes.toString(),
                    fontSize = 12.sp,
                    color = myGray
                )
            }
            Text(
                text = "$comments comments",
                fontSize = 13.sp,
                color = myGray
            )
        }
        Divider(
            thickness = 0.8.dp,
            color = Color.LightGray,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ){
            ActionButton(
                icon = R.drawable.like,
                text = "Like",
                modifier = Modifier.weight(1f)
            )
            ActionButton(
                icon = R.drawable.comment,
                text = "Comment",
                modifier = Modifier.weight(1f)
            )
            ActionButton(
                iconVector = Icons.Outlined.Share,
                text = "Share",
                modifier = Modifier.weight(1f)
            )
            ActionButton(
                iconVector = Icons.Filled.Send,
                text = "Send",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ActionButton(
    text: String,
    icon: Int? = null,
    iconVector: ImageVector? = null,
    modifier: Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        icon?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = text,
                modifier = Modifier.size(16.dp))
        }
        iconVector?.let {
            Icon(
                imageVector = iconVector,
                contentDescription = text,
                modifier = Modifier.size(16.dp)
            )
        }
        Text(
            text = text,
            fontSize = 11.sp
        )
    }
}

@Preview
@Composable
fun Preview() {
    HomeScreen()
}