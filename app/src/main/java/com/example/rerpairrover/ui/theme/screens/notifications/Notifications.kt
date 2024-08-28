package com.example.rerpairrover.ui.theme.screens.notifications


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.example.rerpairrover.navigation.ROUT_HOME
import com.example.rerpairrover.ui.theme.YellowIvy


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NotificationsScreen(navController: NavController){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(YellowIvy)) {

        TopAppBar(
            title = { Text(
                text = "Notifications",
                fontFamily = FontFamily.SansSerif,
                fontSize = 30.sp) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(YellowIvy),

            navigationIcon = {
                IconButton(onClick = { navController.navigate(ROUT_HOME )}) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "menu",)

                }
            },

            )

        Column {

            //Start of main card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(900.dp),
                shape = RoundedCornerShape(40.dp),
                colors = CardDefaults.cardColors(Color.White)

            ) {

              
            }

        }

    }

}




val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon= Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Bookings",
        route="menu",
        selectedIcon=Icons.Filled.DateRange,
        unselectedIcon=Icons.Outlined.DateRange,
        hasNews = true,
        badges=5
    ),

    BottomNavItem(
        title = "Locate Us",
        route="property",
        selectedIcon=Icons.Filled.Place,
        unselectedIcon=Icons.Outlined.Place,
        hasNews = true,
        badges=1
    ),

    BottomNavItem(
        title = "Settings",
        route="settings",
        selectedIcon=Icons.Filled.Settings,
        unselectedIcon=Icons.Outlined.Settings,
        hasNews = true,
        badges=1
    ),


    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews :Boolean,
    val badges :Int
)






@Composable
@Preview(showBackground = true)
fun NotificationsScreenPreview(){
    NotificationsScreen(rememberNavController())

}

