package com.omkarcodes.composelinkedinui.models

import com.omkarcodes.composelinkedinui.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String){
    object Home: NavigationItem("home", R.drawable.ic_home,"Home")
    object Network: NavigationItem("network", R.drawable.ic_network,"My Network")
    object Post: NavigationItem("post", R.drawable.ic_add_post,"Post")
    object Notifications: NavigationItem("notifications", R.drawable.ic_notifications,"Notifications")
    object Jobs: NavigationItem("jobs", R.drawable.ic_jobs,"Jobs")
}
