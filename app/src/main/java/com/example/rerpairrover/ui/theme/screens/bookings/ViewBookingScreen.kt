package com.example.rerpairrover.ui.theme.screens.bookings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rerpairrover.navigation.ROUT_HOME
import com.example.rerpairrover.ui.theme.YellowIvy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewBookingScreen(navController: NavController){

   Column(modifier = Modifier
      .fillMaxSize()
      .background(YellowIvy),
   ) {

      TopAppBar(
         title = { Text(
            text = "My Bookings",
            fontFamily = FontFamily.SansSerif,
            fontSize = 30.sp) },
         colors = TopAppBarDefaults.mediumTopAppBarColors(YellowIvy),

         navigationIcon = {
            IconButton(onClick = { navController.navigate(ROUT_HOME )}) {
               Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "menu",)

            }
         },

         )

      Spacer(modifier = Modifier.height(10.dp))

      Column(modifier = Modifier) {
         //Start of Main Card
         Card(
            modifier = Modifier
               .fillMaxWidth()
               .height(800.dp)
               .clickable { navController.navigate(ROUT_HOME) },
            shape = RoundedCornerShape(40.dp),
            colors = CardDefaults.cardColors(Color.White)

         ) {




         }
         //End of Main Card

      }

   }

}

@Composable
@Preview(showBackground = true)
fun ViewBookingScreenPreview(){
   ViewBookingScreen(rememberNavController())
}