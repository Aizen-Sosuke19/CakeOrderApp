package com.example.cakeorderapp.ui.theme.nav

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Signup : Screen("signup")
    object ForgotPassword : Screen("forgot_password")
    object Home : Screen("home")
    object AddEditCake : Screen("add_edit_cake")
    object CakeDetail : Screen("cake_detail")
}
