package com.example.cakeorderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cakeorderapp.ui.theme.Screens.ForgotPasswordScreen
import com.example.cakeorderapp.ui.theme.Screens.LoginScreen
import com.example.cakeorderapp.ui.theme.Screens.SignupScreen
import com.example.cakeorderapp.ui.theme.nav.HomeScreen
import com.google.firebase.auth.FirebaseAuth

class AuthenticationScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // surface represents the frame of the screen
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    // make a call to the navcontroller function
                    // for navigation purpose we set up a navcontroller
                    // to redirect screens based off a click event
                    AppNavigation()
                }
            }
        }
    }
    @Composable
    fun AppNavigation(){
        // The NavController is part of the navigation concept of
        // jetpack compose. It manages app navigation = it helps in
        // movement between different composable and handles the back
        // stack  A <-> B <-> C
        // NavController "
        // 1. You tell it where to go ( navigate() )
        // 2. It remembers where you've been
        // 3. And it lets you go back ( popBackStack() )
        // Initialize the navcontroller reference
        val navController = rememberNavController()
        // set up a  to host anavhostll app's routes (paths)  /home . /login,
        // the routes are identified using names that map to composables
        NavHost(navController = navController, startDestination = "login") {
            // inside this we then add our composables with the path names
            composable("login") {  LoginScreen(navController)  }
            composable("forgot_password") {  ForgotPasswordScreen(navController)  }
            composable("signup") {  SignupScreen(navController)  }
            composable("home") {  HomeScreen(navController)  }
            // add more routes to composables for this screen here
        }
    }
    @Composable
    fun LoginScreen(navController: NavController){
        val username = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val passwordVisible = remember { mutableStateOf(false) }

        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center ) {
            Card(modifier = Modifier.fillMaxWidth().padding(24.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp )
            ) {
                Column(modifier= Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally)
                {

                    // space
                    Spacer(modifier = Modifier.height(32.dp))
                    // username text field
                    OutlinedTextField(
                        value = username.value,
                        onValueChange = {username.value = it},
                        label = {Text("Username or Email")},
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        colors = TextFieldDefaults.colors(
                            focusedTextColor = MaterialTheme
                                .colorScheme.onSurface,
                            unfocusedTextColor = MaterialTheme
                                .colorScheme.onSurfaceVariant,
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Gray
                        )
                    )
                    // spacer
                    Spacer(modifier = Modifier.height(16.dp))
                    // password
                    OutlinedTextField(
                        value = password.value,
                        onValueChange = {password.value = it},
                        label = {Text("Password")},
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        colors = TextFieldDefaults.colors(
                            focusedTextColor = MaterialTheme
                                .colorScheme.onSurface,
                            unfocusedTextColor = MaterialTheme
                                .colorScheme.onSurfaceVariant,
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Gray
                        ),
                        visualTransformation = if(passwordVisible
                                .value) VisualTransformation.None else
                            PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisible.value =
                                    !passwordVisible.value
                            }) {
                                Icon(
                                    imageVector = if(
                                        passwordVisible.value
                                    ) Icons.Filled.ThumbUp else
                                        Icons.Filled.AccountBox,
                                    contentDescription = ""
                                )
                            }
                        }

                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    // Clickable Text
                    Text(
                        text = "Forgot Password ?",
                        style = MaterialTheme.typography.bodySmall.
                        copy(color = MaterialTheme.colorScheme.primary),
                        modifier = Modifier.align(Alignment.End).
                        clickable(onClick = {
//                               handle reset password functionality here
                        })
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    // login button
                    Button(
                        onClick = { /* handle login */ },
                        modifier = Modifier.fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.
                            primary ,
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Log In", fontSize = 16.sp)
                    }
                    // Linking element to launch the signup composable
                    Text(
                        text = "Don't have an account ? Login here",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.clickable {
                            navController.navigate("signup")
                        }
                    )

                }
            }
        }
    }
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




}