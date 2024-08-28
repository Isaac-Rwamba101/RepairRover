package com.example.rerpairrover.ui.theme.screens.bookings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun BookingsScreen(navController: NavController){
   Column(modifier = Modifier.fillMaxSize()) {



   }

}

@Composable
@Preview(showBackground = true)
fun BookingsScreenPreview(){
   BookingsScreen(rememberNavController())
}