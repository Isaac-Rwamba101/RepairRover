package com.example.rerpairrover.ui.theme.screens.home


import android.annotation.SuppressLint
import android.content.Intent
import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rerpairrover.R
import com.example.rerpairrover.navigation.ROUT_HOME
import com.example.rerpairrover.ui.theme.Orange
import com.example.rerpairrover.ui.theme.PurpleIvy
import com.example.rerpairrover.ui.theme.YellowIvy


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){

   Column(modifier = Modifier.fillMaxSize()) {

       var selected by remember { mutableIntStateOf(0) }
       Scaffold(
           bottomBar = {
               NavigationBar(
                   containerColor = YellowIvy,
                   contentColor = Color.Red
               ) {
                   bottomNavItems.forEachIndexed { index, bottomNavItem ->
                       NavigationBarItem(
                           selected = index == selected,
                           onClick = {
                               selected = index
                               navController.navigate(bottomNavItem.route)
                           },
                           icon = {
                               BadgedBox(
                                   badge = {
                                       if (bottomNavItem.badges != 0) {
                                           Badge {
                                               Text(text = bottomNavItem.badges.toString())
                                           }
                                       } else if (bottomNavItem.hasNews) {
                                           Badge()
                                       }
                                   }
                               ) {
                                   Icon(imageVector =
                                   if (index == selected)
                                       bottomNavItem.selectedIcon
                                   else
                                       bottomNavItem.unselectedIcon,
                                       contentDescription = bottomNavItem.title)
                               }

                           },
                           label = {
                               Text(text = bottomNavItem.title)
                           })
                   }
               }
           },

           topBar = {
               TopAppBar(
                   title = { Text(text = "RepairRovers") },
                   colors = TopAppBarDefaults.mediumTopAppBarColors(YellowIvy),

                           navigationIcon = {
                       IconButton(onClick = { /*TODO*/ }) {
                           Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "menu",)

                       }
                   },
                   actions = {
                       IconButton(onClick = { /*TODO*/ }) {
                           Icon(imageVector = Icons.Default.Notifications, contentDescription = "menu",)

                       }

                   }
               )
           },



           //Content Section
           content = @Composable{
               Column(
                   modifier = Modifier
                       .fillMaxSize()
                       .padding(top = 70.dp, start = 20.dp, end = 20.dp)
                       .horizontalScroll(rememberScrollState()),
               ){
                       //Start of main card
                       Card(modifier = Modifier
                           .fillMaxWidth()
                           .height(700.dp)
                           .clickable { navController.navigate(ROUT_HOME) }
                           .padding(top = 20.dp),
                           colors = CardDefaults.cardColors(Color.White)
                       ) {

                           //Row1
                           Row(modifier = Modifier.padding(20.dp)) {
                               //Card
                               Card(modifier = Modifier
                                   .width(100.dp)
                                   .height(120.dp)
                                   .clickable { navController.navigate(ROUT_HOME) }) {
                                   Column {

                                       Spacer(modifier = Modifier.height(10.dp))
                                       Box(modifier = Modifier.fillMaxWidth(),
                                           contentAlignment = Alignment.Center) {
                                           Image(painter = painterResource(
                                               id = R.drawable.serve
                                           ),
                                               contentDescription ="home",
                                               modifier = Modifier.size(60.dp) )


                                       }
                                       Spacer(modifier = Modifier.height(10.dp))

                                       Text(text = "Home",
                                           fontSize = 18.sp,
                                           fontFamily = FontFamily.Serif,
                                           modifier = Modifier.fillMaxWidth(),
                                           textAlign = TextAlign.Center
                                       )

                                   }
                               }
                               //End of card
                               Spacer(modifier = Modifier.width(10.dp))

                               Card(modifier = Modifier
                                   .width(100.dp)
                                   .height(120.dp)
                                   .clickable { navController.navigate(ROUT_HOME) }) {
                                   Column {

                                       Spacer(modifier = Modifier.height(10.dp))
                                       Box(modifier = Modifier.fillMaxWidth(),
                                           contentAlignment = Alignment.Center) {
                                           Image(painter = painterResource(
                                               id = R.drawable.img_2
                                           ),
                                               contentDescription ="home",
                                               modifier = Modifier.size(60.dp) )


                                       }
                                       Spacer(modifier = Modifier.height(10.dp))

                                       Text(text = "Property",
                                           fontSize = 18.sp,
                                           fontFamily = FontFamily.Serif,
                                           modifier = Modifier.fillMaxWidth(),
                                           textAlign = TextAlign.Center
                                       )

                                   }
                               }
                               //End of card
                               Spacer(modifier = Modifier.width(10.dp))

                               //Card
                               Card(modifier = Modifier
                                   .width(100.dp)
                                   .height(120.dp)
                                   .clickable { navController.navigate(ROUT_HOME) }) {
                                   Column {

                                       Spacer(modifier = Modifier.height(10.dp))
                                       Box(modifier = Modifier.fillMaxWidth(),
                                           contentAlignment = Alignment.Center) {
                                           Image(painter = painterResource(
                                               id = R.drawable.serve
                                           ),
                                               contentDescription ="home",
                                               modifier = Modifier.size(60.dp) )


                                       }
                                       Spacer(modifier = Modifier.height(10.dp))

                                       Text(text = "Home",
                                           fontSize = 18.sp,
                                           fontFamily = FontFamily.Serif,
                                           modifier = Modifier.fillMaxWidth(),
                                           textAlign = TextAlign.Center
                                       )

                                   }
                               }
                               //End of card
                               Spacer(modifier = Modifier.width(10.dp))

                               //Card
                               Card(modifier = Modifier
                                   .width(100.dp)
                                   .height(120.dp)
                                   .clickable { navController.navigate(ROUT_HOME) }) {
                                   Column {

                                       Spacer(modifier = Modifier.height(10.dp))
                                       Box(modifier = Modifier.fillMaxWidth(),
                                           contentAlignment = Alignment.Center) {
                                           Image(painter = painterResource(
                                               id = R.drawable.serve
                                           ),
                                               contentDescription ="home",
                                               modifier = Modifier.size(60.dp) )


                                       }
                                       Spacer(modifier = Modifier.height(10.dp))

                                       Text(text = "Home",
                                           fontSize = 18.sp,
                                           fontFamily = FontFamily.Serif,
                                           modifier = Modifier.fillMaxWidth(),
                                           textAlign = TextAlign.Center
                                       )

                                   }
                               }
                               //End of card

                           }
                           //End of row1


                           //Row2
                           Row(modifier = Modifier.padding(20.dp)) {
                               //Card
                               Card(modifier = Modifier
                                   .width(100.dp)
                                   .height(120.dp),
                                   elevation = CardDefaults.cardElevation()) {
                                   Column {

                                       Spacer(modifier = Modifier.height(10.dp))
                                       Box(modifier = Modifier.fillMaxWidth(),
                                           contentAlignment = Alignment.Center) {
                                           Image(painter = painterResource(
                                               id = R.drawable.serve
                                           ),
                                               contentDescription ="home",
                                               modifier = Modifier.size(60.dp) )


                                       }
                                       Spacer(modifier = Modifier.height(10.dp))

                                       Text(text = "Profile",
                                           fontSize = 18.sp,
                                           fontFamily = FontFamily.Serif,
                                           modifier = Modifier.fillMaxWidth(),
                                           textAlign = TextAlign.Center
                                       )

                                   }
                               }
                               //End of card
                               Spacer(modifier = Modifier.width(10.dp))

                               Card(modifier = Modifier
                                   .width(100.dp)
                                   .height(120.dp)) {
                                   Column {

                                       Spacer(modifier = Modifier.height(10.dp))
                                       Box(modifier = Modifier.fillMaxWidth(),
                                           contentAlignment = Alignment.Center) {
                                           Image(painter = painterResource(
                                               id = R.drawable.img_2
                                           ),
                                               contentDescription ="home",
                                               modifier = Modifier.size(60.dp) )


                                       }
                                       Spacer(modifier = Modifier.height(10.dp))

                                       Text(text = "Settings",
                                           fontSize = 18.sp,
                                           fontFamily = FontFamily.Serif,
                                           modifier = Modifier.fillMaxWidth(),
                                           textAlign = TextAlign.Center
                                       )

                                   }
                               }
                               //End of card
                               Spacer(modifier = Modifier.width(10.dp))

                               //Card
                               Card(modifier = Modifier
                                   .width(100.dp)
                                   .height(120.dp)
                                   .clickable { navController.navigate(ROUT_HOME) }) {
                                   Column {

                                       Spacer(modifier = Modifier.height(10.dp))
                                       Box(modifier = Modifier.fillMaxWidth(),
                                           contentAlignment = Alignment.Center) {
                                           Image(painter = painterResource(
                                               id = R.drawable.serve
                                           ),
                                               contentDescription ="home",
                                               modifier = Modifier.size(60.dp) )


                                       }
                                       Spacer(modifier = Modifier.height(10.dp))

                                       Text(text = "Home",
                                           fontSize = 18.sp,
                                           fontFamily = FontFamily.Serif,
                                           modifier = Modifier.fillMaxWidth(),
                                           textAlign = TextAlign.Center
                                       )

                                   }
                               }
                               //End of card
                               Spacer(modifier = Modifier.width(10.dp))

                               //Card
                               Card(modifier = Modifier
                                   .width(100.dp)
                                   .height(120.dp)
                                   .clickable { navController.navigate(ROUT_HOME) }) {
                                   Column {

                                       Spacer(modifier = Modifier.height(10.dp))
                                       Box(modifier = Modifier.fillMaxWidth(),
                                           contentAlignment = Alignment.Center) {
                                           Image(painter = painterResource(
                                               id = R.drawable.serve
                                           ),
                                               contentDescription ="home",
                                               modifier = Modifier.size(60.dp) )


                                       }
                                       Spacer(modifier = Modifier.height(10.dp))

                                       Text(text = "Home",
                                           fontSize = 18.sp,
                                           fontFamily = FontFamily.Serif,
                                           modifier = Modifier.fillMaxWidth(),
                                           textAlign = TextAlign.Center
                                       )

                                   }
                               }
                               //End of card

                           }
                           //End of row2



                           //Row3
                           Row(modifier = Modifier.padding(20.dp)) {
                               //Card
                               Card(modifier = Modifier
                                   .width(100.dp)
                                   .height(120.dp)
                                   .clickable { navController.navigate(ROUT_HOME) }) {
                                   Column {

                                       Spacer(modifier = Modifier.height(10.dp))
                                       Box(modifier = Modifier.fillMaxWidth(),
                                           contentAlignment = Alignment.Center) {
                                           Image(painter = painterResource(
                                               id = R.drawable.serve
                                           ),
                                               contentDescription ="home",
                                               modifier = Modifier.size(60.dp) )


                                       }
                                       Spacer(modifier = Modifier.height(10.dp))

                                       Text(text = "Add Products",
                                           fontSize = 18.sp,
                                           fontFamily = FontFamily.Serif,
                                           modifier = Modifier.fillMaxWidth(),
                                           textAlign = TextAlign.Center
                                       )



                                   }
                               }
                               //End of card
                               Spacer(modifier = Modifier.width(10.dp))

                               Card(modifier = Modifier
                                   .width(100.dp)
                                   .height(120.dp)
                                   .clickable { navController.navigate(ROUT_HOME) }) {
                                   Column {

                                       Spacer(modifier = Modifier.height(10.dp))
                                       Box(modifier = Modifier.fillMaxWidth(),
                                           contentAlignment = Alignment.Center) {
                                           Image(painter = painterResource(
                                               id = R.drawable.img_2
                                           ),
                                               contentDescription ="home",
                                               modifier = Modifier.size(60.dp) )


                                       }
                                       Spacer(modifier = Modifier.height(10.dp))

                                       Text(text = "View Products",
                                           fontSize = 18.sp,
                                           fontFamily = FontFamily.Serif,
                                           modifier = Modifier.fillMaxWidth(),
                                           textAlign = TextAlign.Center
                                       )


                                   }
                               }
                               //End of card
                               Spacer(modifier = Modifier.width(10.dp))

                               //Card
                               Card(modifier = Modifier
                                   .width(100.dp)
                                   .height(120.dp)
                                   .clickable { navController.navigate(ROUT_HOME) }) {
                                   Column {

                                       Spacer(modifier = Modifier.height(10.dp))
                                       Box(modifier = Modifier.fillMaxWidth(),
                                           contentAlignment = Alignment.Center) {
                                           Image(painter = painterResource(
                                               id = R.drawable.serve
                                           ),
                                               contentDescription ="home",
                                               modifier = Modifier.size(60.dp) )


                                       }
                                       Spacer(modifier = Modifier.height(10.dp))

                                       Text(text = "Home",
                                           fontSize = 18.sp,
                                           fontFamily = FontFamily.Serif,
                                           modifier = Modifier.fillMaxWidth(),
                                           textAlign = TextAlign.Center
                                       )

                                   }
                               }
                               //End of card
                               Spacer(modifier = Modifier.width(10.dp))

                               //Card
                               Card(modifier = Modifier
                                   .width(100.dp)
                                   .height(120.dp)
                                   .clickable { navController.navigate(ROUT_HOME) }) {
                                   Column {

                                       Spacer(modifier = Modifier.height(10.dp))
                                       Box(modifier = Modifier.fillMaxWidth(),
                                           contentAlignment = Alignment.Center) {
                                           Image(painter = painterResource(
                                               id = R.drawable.serve
                                           ),
                                               contentDescription ="home",
                                               modifier = Modifier.size(60.dp) )


                                       }
                                       Spacer(modifier = Modifier.height(10.dp))

                                       Text(text = "Home",
                                           fontSize = 18.sp,
                                           fontFamily = FontFamily.Serif,
                                           modifier = Modifier.fillMaxWidth(),
                                           textAlign = TextAlign.Center
                                       )

                                   }
                               }
                               //End of card

                           }
                           //End of row3


                       }
                       //End of main card

                   }
                   //End of ROW1






           }

       )

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
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())

}

