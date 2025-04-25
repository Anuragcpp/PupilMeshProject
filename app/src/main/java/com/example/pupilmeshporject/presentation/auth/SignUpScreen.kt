package com.example.pupilmeshporject.presentation.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignUpScreen(
    viewModel: AuthViewModel,
    navigateToSignIn : () -> Unit,
    navigateToMainScreen : () -> Unit
) {

    BoxWithConstraints(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
        .padding(horizontal = 5.dp, vertical = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        val halfHeight = maxHeight/2

        Card (modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .height(halfHeight)
            .align(Alignment.Center),
            colors = CardDefaults.cardColors(contentColor = Color.DarkGray)
        ) {

            Column (
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Sign UP Screen",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    textAlign = TextAlign.Center
                )

                OutlinedTextField(
                    value = viewModel.email,
                    onValueChange = { viewModel.email = it},
                    label = { Text(text = "Email") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = viewModel.password,
                    onValueChange = { viewModel.password = it},
                    label = { Text(text = "Password") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Forget Password? ",
                        style = TextStyle(
                            fontSize = 18.sp,
                            textDecoration = TextDecoration.Underline,
                            color = Color.Blue
                        )
                    )


                }

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = {
                        viewModel.onSignUpClick()
                        if (viewModel.navigateToHome) navigateToMainScreen()
                              },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Sign Up",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )


                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Don't have an account? ",
                        style = TextStyle(
                            fontSize = 18.sp,
                        )
                    )

                    Text(
                        text = "Sign In",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.clickable { navigateToSignIn() }
                    )

                }

                Spacer(modifier = Modifier.height(10.dp))

                viewModel.error.let {
                    Text(
                        text = " $it",
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color.Red
                        )
                    )
                }

            }

        }

    }
}