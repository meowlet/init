package com.meow.fore

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.meow.fore.auth.AuthViewModel
import com.meow.fore.auth.ForgetPasswordScreen
import com.meow.fore.auth.SignInScreen
import com.meow.fore.auth.SignUpScreen
import com.meow.fore.home.HomeScreen
import com.meow.fore.home.HomeScreenViewModel

@Composable
fun Navigation(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    homeScreenViewModel: HomeScreenViewModel
) {
    NavHost(navController = navController, startDestination = AuthRoutes.SignIn.name) {
        authGraph(authViewModel, navController)
        homeGraph(homeScreenViewModel, navController)
    }
}

fun NavGraphBuilder.authGraph(
    authViewModel: AuthViewModel,
    navController: NavHostController
) {
    composable(AuthRoutes.SignIn.name) {
        SignInScreen(
            viewModel = authViewModel,
            onNavigateToSignUp = {
                navController.navigate(AuthRoutes.SignUp.name)
            },
            onNavigateToForgetPassword = {
                navController.navigate(AuthRoutes.ForgotPassword.name)
            },
            onNavigateToHome = {
                navController.navigate(BottomNavigationItem.Home.route)
            }
        )
    }
    composable(AuthRoutes.SignUp.name) {
        SignUpScreen(
            viewModel = authViewModel,
            onNavigateToSignIn = {
                navController.navigate(AuthRoutes.SignIn.name)
            }
        )
    }
    composable(AuthRoutes.ForgotPassword.name) {
        ForgetPasswordScreen(
            viewModel = authViewModel,
            onNavigateToSignIn = {
                navController.navigate(AuthRoutes.SignIn.name)
            }
        )
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