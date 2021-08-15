package com.omkarcodes.composelinkedinui.ui.composables

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.omkarcodes.composelinkedinui.models.NavigationItem
import com.omkarcodes.composelinkedinui.ui.theme.myGray


@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Network,
        NavigationItem.Post,
        NavigationItem.Notifications,
        NavigationItem.Jobs,
    )
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach {
            BottomNavigationItem(
                icon = { Icon(painter = painterResource(id = it.icon), contentDescription = it.title, modifier = Modifier.size(21.dp)) },
                label = { Text(text = it.title, fontSize = 10.sp, maxLines = 1, overflow = TextOverflow.Ellipsis) },
                selectedContentColor = Color.Black,
                unselectedContentColor = myGray,
                alwaysShowLabel = true,
                selected = currentRoute == it.route,
                onClick = {
                    navController.navigate(it.route)
                },
            )
        }
    }
}