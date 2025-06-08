package com.example.cakeorderapp.ui.theme.Screens

import android.widget.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.cakeorderapp.ui.theme.nav.Screen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LoginScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Login Screen")
        Button(onClick = {
            FirebaseAuth.getInstance().signInAnonymously().addOnCompleteListener {
                if (it.isSuccessful) {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            }
        })
            Text("Login ")
        }
    TextButton(onClick = {
        navController.navigate("forgot_password")
    }) {
        Text("Forgot Password?")
    }

}

