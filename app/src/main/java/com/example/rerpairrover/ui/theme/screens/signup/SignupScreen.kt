package com.example.repairrover.ui.theme.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rerpairrover.R
import com.example.rerpairrover.data.AuthViewModel
import com.example.rerpairrover.navigation.ROUT_LOGIN
import com.example.rerpairrover.ui.theme.YellowIvy

@Composable
fun SignupScreen(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(painterResource(id = R.drawable.img_5), contentScale = ContentScale.FillBounds),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.serve),
            contentDescription = "home",
            modifier = Modifier
                .size(150.dp),
            contentScale = ContentScale.Crop

        )


        Text(
            text = "GearHeads Garage",
            fontSize = 50.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red,
        )

        Text(
            text = "Rev up your ride with ease!",
            fontSize = 20.sp,
            fontFamily = FontFamily.Default
        )

        Spacer(modifier = Modifier.height(50.dp))



        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confpassword by remember { mutableStateOf("") }
        var passwordVisible1 by remember { mutableStateOf(false) }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .height(630.dp).padding(20.dp),
                shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp, bottomEnd = 30.dp, bottomStart = 30.dp),
                colors = CardDefaults.cardColors(Color.White)

            ) {





                OutlinedTextField(
                    value = name,
                    onValueChange = {name = it},
                    label = { Text(text = "Full Name")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "", tint = YellowIvy)},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )

                Spacer(modifier = Modifier.height(20.dp))


                OutlinedTextField(
                    value = email,
                    onValueChange = {email = it},
                    label = { Text(text = "Email Address")},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "", tint = YellowIvy)},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )

                Spacer(modifier = Modifier.height(20.dp))

                var passwordVisible by remember { mutableStateOf(false) }
                // Function to determine visual transformation based on visibility
                val visualTransformation: VisualTransformation =
                    if (passwordVisible) VisualTransformation.None
                    else PasswordVisualTransformation()
                // Function to switch the password visibility
                fun togglePasswordVisibility() {
                    passwordVisible = !passwordVisible
                }

                OutlinedTextField(
                    value = password,
                    onValueChange = {password = it},
                    label = { Text(text = "Password", fontFamily = FontFamily.SansSerif)},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "",tint = YellowIvy) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    shape = RoundedCornerShape(5.dp),
                    visualTransformation = visualTransformation,
                    trailingIcon = {
                        val icon = if (passwordVisible) {
                            //Download a password show icon
                            painterResource(id = R.drawable.show)
                        } else {
                            //Download a password hide icon
                            painterResource(id = R.drawable.hide)
                        }
                        IconButton(onClick = { togglePasswordVisibility() }) {
                            Icon(painter = icon, contentDescription = null)
                        }
                    }

                )

                Spacer(modifier = Modifier.height(20.dp))

                var passwordVisible2 by remember { mutableStateOf(false) }
                // Function to determine visual transformation based on visibility
                val visualTransformation2: VisualTransformation =
                    if (passwordVisible) VisualTransformation.None
                    else PasswordVisualTransformation()
                // Function to switch the password visibility
                fun togglePasswordVisibility2() {
                    passwordVisible = !passwordVisible
                }

                OutlinedTextField(
                    value = password,
                    onValueChange = {password = it},
                    label = { Text(text = "Confirm Password", fontFamily = FontFamily.SansSerif)},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "",tint = YellowIvy) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    shape = RoundedCornerShape(5.dp),
                    visualTransformation = visualTransformation,
                    trailingIcon = {
                        val icon = if (passwordVisible) {
                            //Download a password show icon
                            painterResource(id = R.drawable.show,)
                        } else {
                            //Download a password hide icon
                            painterResource(id = R.drawable.hide)
                        }
                        IconButton(onClick = { togglePasswordVisibility() }) {
                            Icon(painter = icon, contentDescription = null)
                        }
                    }

                )

                Spacer(modifier = Modifier.height(20.dp))



                val context = LocalContext.current
                val authViewModel = AuthViewModel(navController, context)
                Button(onClick = {
                    authViewModel.signup(name, email, password,confpassword)
                },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(start = 20.dp, end = 20.dp),
                    colors = ButtonDefaults.buttonColors(YellowIvy),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Create An Account")

                }

                Spacer(modifier = Modifier.height(20.dp))


                Button(onClick = {  navController.navigate(ROUT_LOGIN) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(start = 20.dp, end = 20.dp),
                    colors = ButtonDefaults.buttonColors(YellowIvy),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = "Log In")

                }

            }











    }

}

@Composable
@Preview(showBackground = true)
fun SignupScreenPreview(){
    SignupScreen(rememberNavController())
}