package com.example.cakeorderapp.ui.theme.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cakeorderapp.ui.theme.nav.Screen
import com.google.firebase.auth.FirebaseAuth
import com.example.cakeorderapp.R
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

