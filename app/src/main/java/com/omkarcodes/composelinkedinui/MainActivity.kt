package com.omkarcodes.composelinkedinui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.omkarcodes.composelinkedinui.models.NavigationItem
import com.omkarcodes.composelinkedinui.ui.composables.BottomNavigationBar
import com.omkarcodes.composelinkedinui.ui.composables.TopBar
import com.omkarcodes.composelinkedinui.ui.screens.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ){
        Box(modifier = Modifier.padding(bottom = it.calculateBottomPadding())) {
            Navigation(navController)
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Home.route
    ){
        composable(NavigationItem.Home.route){
            HomeScreen()
        }
        composable(NavigationItem.Network.route){
            NetworkScreen()
        }
        composable(NavigationItem.Post.route){
            AddPostScreen()
        }
        composable(NavigationItem.Notifications.route){
            NotificationsScreen()
        }
        composable(NavigationItem.Jobs.route){
            JobsScreen()
        }
    }
}