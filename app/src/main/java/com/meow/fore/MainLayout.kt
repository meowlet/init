package com.meow.fore

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.meow.fore.auth.AuthViewModel
import com.meow.fore.home.HomeScreenViewModel

@Composable
fun MainLayout() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    //ViewModels
    val authViewModel = viewModel(modelClass = AuthViewModel::class.java)
    val homeScreenViewModel = viewModel(modelClass = HomeScreenViewModel::class.java)


    Scaffold(
        topBar = {

        },
        bottomBar = {
            AnimatedVisibility(
                //if the current destination is not in the list of bottom navigation items, hide the bottom navigation
                visible = currentDestination?.hierarchy?.any { destination ->
                    bottomNavigationItems.any { it.route == destination.route }
                } == true,
                enter = slideInVertically(initialOffsetY = { -it }),
                exit = slideOutVertically(targetOffsetY = { -it }),
            ) {
                NavigationBar {
                    bottomNavigationItems.forEach { item ->
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    imageVector = if (
                                        currentDestination?.hierarchy?.any { it.route == item.route } == true
                                    ) {
                                        item.selectedIcon
                                    } else {
                                        item.unselectedIcon
                                    },
                                    contentDescription = null)
                            },
                            label = {
                                Text(text = item.title)
                            },
                            selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                            onClick = {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.startDestinationId)
                                    launchSingleTop = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Navigation(navController, authViewModel, homeScreenViewModel)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainLayoutPreview() {
    MainLayout()
}

sealed class BottomNavigationItem(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    object Home : BottomNavigationItem("home", "Home", Icons.Filled.Home, Icons.Outlined.Home)
    object Search :
        BottomNavigationItem("search", "Search", Icons.Filled.Search, Icons.Outlined.Search)

    object Profile :
        BottomNavigationItem("profile", "Profile", Icons.Filled.Person, Icons.Outlined.Person)

    object Settings :
        BottomNavigationItem("settings", "Settings", Icons.Filled.Settings, Icons.Outlined.Settings)
}

val bottomNavigationItems = listOf(
    BottomNavigationItem.Home,
    BottomNavigationItem.Search,
    BottomNavigationItem.Profile,
    BottomNavigationItem.Settings
)