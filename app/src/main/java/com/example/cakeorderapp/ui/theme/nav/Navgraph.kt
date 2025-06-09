package com.example.cakeorderapp.ui.theme.nav

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cakeorderapp.ui.theme.Screens.ForgotPasswordScreen
import com.example.cakeorderapp.ui.theme.Screens.LoginScreen
import com.example.cakeorderapp.ui.theme.Screens.SignupScreen
import com.example.cakeorderapp.ui.theme.Screens.SplashScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) { SplashScreen(navController) }
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Signup.route) { SignupScreen(navController) }
        composable(Screen.ForgotPassword.route) { ForgotPasswordScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.AddEditCake.route) { AddEditCakeScreen(navController) }
        composable(Screen.CakeDetail.route) { CakeDetailScreen(navController) }
    }
}

@Composable
fun CakeDetailScreen(x0: NavHostController) {
    TODO("Not yet implemented")
}

@Composable
fun AddEditCakeScreen(x0: NavHostController) {
    TODO("Not yet implemented")
}

@Composable
fun HomeScreen(x0: NavHostController) {
    TODO("Not yet implemented")
}
