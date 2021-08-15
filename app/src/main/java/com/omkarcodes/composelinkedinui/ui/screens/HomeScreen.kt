package com.omkarcodes.composelinkedinui.ui.screens

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
import com.omkarcodes.composelinkedinui.R
import com.omkarcodes.composelinkedinui.models.FollowingReaction
import com.omkarcodes.composelinkedinui.models.Post
import com.omkarcodes.composelinkedinui.models.Story
import com.omkarcodes.composelinkedinui.models.User
import com.omkarcodes.composelinkedinui.ui.composables.PostItem
import com.omkarcodes.composelinkedinui.ui.composables.StorySection

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(8.dp))
            }
            item {
                StorySection(
                    stories = listOf(
                        Story(image = painterResource(id = R.drawable.me),"Your Story",),
                        Story(image = painterResource(id = R.drawable.google),"Google",),
                        Story(image = painterResource(id = R.drawable.amazon),"Amazon",),
                        Story(image = painterResource(id = R.drawable.codechef),"CodeChef",),
                        Story(image = painterResource(id = R.drawable.swiggy),"Swiggy",),
                        Story(image = painterResource(id = R.drawable.ms),"Microsoft",),
                        Story(image = painterResource(id = R.drawable.zomato),"Zomato",),
                        Story(image = painterResource(id = R.drawable.hackerrank),"HackerRank",),
                        Story(image = painterResource(id = R.drawable.paytm),"Paytm",),
                    )
                )
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
            }
            val posts = listOf(
                Post(
                    user = User("Amazon","20,531,993 Followers", R.drawable.amazon),
                    text = "Sarah Rhoads, vice president of Amazon Global Air and former U.S. Navy F/A-18 E/F pilot, gives us the scoop on the new Amazon Air Hub that will process millions of customer packages per week.",
                    image = R.drawable.amazon_post,
                    likes = 1850,
                    comments = 59,
                    timestamp = "4h",
                    reactions = listOf(R.drawable.like, R.drawable.love,R.drawable.celebrate),
                    followingReaction = FollowingReaction(name = "Raj Vikramaditya", "likes this")
                ),
                Post(
                    user = User("Google","22,036,179 Followers", R.drawable.google),
                    text = "You’re invited! See how #DeveloperStudentClubs around the world have used Google Technology to support the United Nations 17 Sustainable goals.\nTune in to the 2021 Solution Challenge Demo Day livestream on Aug 26. RSVP here → http://goo.gle/3y7SFmY",
                    image = R.drawable.google_post,
                    likes = 1749,
                    comments = 20,
                    timestamp = "2d",
                    reactions = listOf(R.drawable.like, R.drawable.love,)
                ),
                Post(
                    user = User("Swiggy","753,118 Followers", R.drawable.swiggy),
                    text = "As we wrap up our 7th birthday celebrations, there's yet another remarkable day to celebrate - India's 75th Independence Day!",
                    image = R.drawable.swiggy_post,
                    likes = 79,
                    comments = 5,
                    timestamp = "2h",
                    reactions = listOf(R.drawable.like,R.drawable.celebrate, R.drawable.love,)
                ),
                Post(
                    user = User("CodeChef","325,407 Followers", R.drawable.codechef),
                    text = "There are N breakfasts in the restaurant. The i^{th} breakfast has an attractiveness A_i and cost C_i. \n" +
                            "The Chef has noticed that nobody takes the j^{th} breakfast if there exists at least one breakfast i such that A_i >= A_j and C_i < C_j. \n" +
                            "Find the minimum number of breakfasts whose attractiveness has to be changed by some real number such that the final attractiveness of the i^{th} breakfast lies in the interval [L_i, R_i] so that Chef can have all the breakfasts.",
                    image = R.drawable.codechef_post,
                    likes = 21,
                    comments = 4,
                    timestamp = "25m",
                    reactions = listOf(R.drawable.insightful, R.drawable.curious,)
                ),
                Post(
                    user = User("Microsoft","14,834,203 Followers",R.drawable.ms),
                    text = "Just announced - Microsoft FY21 Q4 Earnings  \n" +
                            "Revenue: \$46.2 billion ⬆️ 21% \n" +
                            "Operating income: \$19.1 billion ⬆️ 42% \n" +
                            "Net Income: \$16.5 billion ⬆️ 47%  \n" +
                            "EPS: \$2.17 ⬆ 49%  \n" +
                            " \n" +
                            "Strong finish to fiscal 2021: \n" +
                            "✅ \$168.1 billion in annual revenue  \n" +
                            "✅ \$69.9 billion in annual operating income \n" +
                            "Commercial cloud annual revenue exceeded \$69 billion ⬆ 34%",
                    image = R.drawable.ms_post,
                    likes = 18107,
                    comments = 209,
                    timestamp = "2w",
                    reactions = listOf(R.drawable.like,R.drawable.celebrate,R.drawable.love)
                )
            )
            items(posts.size){
                PostItem(post = posts[it])
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    HomeScreen()
}
