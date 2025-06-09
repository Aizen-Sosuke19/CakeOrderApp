package com.example.cakeorderapp.ui.theme.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ForgotPasswordScreen(
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Forgot Password", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email Address") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                loading = true
                FirebaseAuth.getInstance()
                    .sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        loading = false
                        message = if (task.isSuccessful) {
                            "Password reset email sent. Check your inbox."
                        } else {
                            "Error: ${task.exception?.localizedMessage}"
                        }
                    }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Send Reset Email")
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = { navController.popBackStack() }) {
            Text("Back to Login")
        }

        if (loading) {
            CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))
        }

        if (message.isNotEmpty()) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = message, color = Color.Blue)
        }
    }
}
