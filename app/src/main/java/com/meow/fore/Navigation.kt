package com.meow.fore

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.meow.fore.auth.AuthViewModel
import com.meow.fore.home.HomeScreen
import com.meow.fore.home.HomeScreenViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    homeScreenViewModel: HomeScreenViewModel
) {
    NavHost(navController = navController, startDestination = "home") {
        authGraph(authViewModel, navController)
        homeGraph(homeScreenViewModel, navController)
    }
}

fun NavGraphBuilder.authGraph(
    authViewModel: AuthViewModel,
    navController: NavHostController
) {
    composable(AuthRoutes.SignIn.name) {
        Text(text = "Sign In")
    }
    composable(AuthRoutes.SignUp.name) {
        Text(text = "Sign Up")
    }
    composable(AuthRoutes.ForgotPassword.name) {
        Text(text = "Forgot Password")
    }
}

fun NavGraphBuilder.homeGraph(
    homeScreenViewModel: HomeScreenViewModel,
    navController: NavHostController
) {
    composable(BottomNavigationItem.Home.route) {
        HomeScreen(homeScreenViewModel)
    }
    composable(BottomNavigationItem.Search.route) {
        Text(text = "Search")
    }
    composable(BottomNavigationItem.Profile.route) {
        Text(text = "Profile")
    }
    composable(BottomNavigationItem.Settings.route) {
        Text(text = "Settings")
    }
}



enum class AuthRoutes {
    SignIn, SignUp, ForgotPassword
}