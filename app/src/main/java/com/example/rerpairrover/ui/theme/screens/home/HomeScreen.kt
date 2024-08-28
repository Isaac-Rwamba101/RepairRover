package com.example.rerpairrover.ui.theme.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rerpairrover.R
import com.example.rerpairrover.navigation.ROUT_ACCESSORIES
import com.example.rerpairrover.navigation.ROUT_BOOKINGS
import com.example.rerpairrover.navigation.ROUT_CONTACTS
import com.example.rerpairrover.navigation.ROUT_MECHANICAL
import com.example.rerpairrover.navigation.ROUT_NOTIFICATIONS
import com.example.rerpairrover.navigation.ROUT_OIL
import com.example.rerpairrover.navigation.ROUT_TYRES
import com.example.rerpairrover.ui.theme.YellowIvy
import com.example.rerpairrover.ui.theme.screens.notifications.bottomNavItems
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){

    //Navigation Drawer

    val drawerState = rememberDrawerState(DrawerValue.Closed)

    val scope = rememberCoroutineScope()

    val menuList = listOf(
        Icons.Filled.Favorite to "about" ,
        Icons.Filled.Settings to "settings",
        Icons.Filled.AccountCircle to "Profile"
    )

    var selectedItem by remember { mutableStateOf(-1) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerHeader()
                menuList.forEachIndexed { index, pair ->
                    NavigationDrawerItem(
                        label = {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                Icon(imageVector = pair.first, contentDescription = pair.second)
                                Spacer(modifier = Modifier.width(15.dp))
                                Text(text = pair.second)
                            }
                        },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index })
                }
            }
        }) {
        Scaffold(

            bottomBar = {
                NavigationBar(
                    containerColor = YellowIvy,
                    contentColor = Color.Red
                ) {
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        var selected: Int? = null
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
                    title = { Text(text = "Homepage") },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(YellowIvy),
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = "")
                        }
                    },

                    actions = {
                        IconButton(onClick = { navController.navigate(ROUT_NOTIFICATIONS)}) {
                            Icon(imageVector = Icons.Default.Notifications, contentDescription = "menu",)

                        }

                    }
                )

            }
        ) {


            //Main Content of the screen

            Column (modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp)
                .horizontalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally){

                //Start of main card
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(700.dp)
                    .padding(top = 20.dp),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Row {
                        Text(
                            text = "PRODUCTS & SERVICES",
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Serif,
                            modifier = Modifier.padding(top = 20.dp, start = 10.dp),
                            color = Color.Red)
                    }

                    //Row1
                    Row(modifier = Modifier.padding(20.dp)) {


                        //Card
                        Card(modifier = Modifier
                            .width(100.dp)
                            .height(120.dp)
                            .clickable { navController.navigate(ROUT_OIL) }
                            .background(Color.White)) {
                            Column {

                                Spacer(modifier = Modifier.height(10.dp))
                                Box(modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center) {
                                    Image(painter = painterResource(
                                        id = R.drawable.oilservice
                                    ),
                                        contentDescription ="home",
                                        modifier = Modifier.size(65.dp) )


                                }
                                Spacer(modifier = Modifier.height(10.dp))

                                Text(text = "Oil Services",
                                    fontSize = 17.sp,
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
                            .clickable { navController.navigate(ROUT_TYRES) }) {
                            Column {

                                Spacer(modifier = Modifier.height(10.dp))
                                Box(modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center) {
                                    Image(painter = painterResource(
                                        id = R.drawable.tyres
                                    ),
                                        contentDescription ="home",
                                        modifier = Modifier.size(75.dp) )


                                }
                                Spacer(modifier = Modifier.height(10.dp))

                                Text(text = "Tyres",
                                    fontSize = 17.sp,
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
                            .clickable { navController.navigate(ROUT_MECHANICAL) }) {
                            Column {

                                Spacer(modifier = Modifier.height(10.dp))
                                Box(modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center) {
                                    Image(painter = painterResource(
                                        id = R.drawable.mechanical
                                    ),
                                        contentDescription ="home",
                                        modifier = Modifier.size(63.dp) )


                                }
                                Spacer(modifier = Modifier.height(10.dp))

                                Text(text = "Mechanical Parts",
                                    fontSize = 17.sp,
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
                            .clickable { navController.navigate(ROUT_ACCESSORIES) }) {
                            Column {

                                Spacer(modifier = Modifier.height(10.dp))
                                Box(modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center) {
                                    Image(painter = painterResource(
                                        id = R.drawable.accessories
                                    ),
                                        contentDescription ="home",
                                        modifier = Modifier.size(65.dp) )


                                }
                                Spacer(modifier = Modifier.height(10.dp))

                                Text(text = "Accessories",
                                    fontSize = 17.sp,
                                    fontFamily = FontFamily.Serif,
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center
                                )

                            }
                        }
                        //End of card

                    }
                    //End of row1

                    Row {
                        Text(
                            text = "CONTACT US",
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Serif,
                            modifier = Modifier.padding(top = 20.dp, start = 10.dp),
                            color = Color.Red)
                    }
                    //Row2
                    Row(modifier = Modifier.padding(20.dp)) {
                        //Card
                        Card(modifier = Modifier
                            .width(100.dp)
                            .height(120.dp)
                            .clickable { navController.navigate(ROUT_CONTACTS) },
                            elevation = CardDefaults.cardElevation()) {
                            Column {

                                Spacer(modifier = Modifier.height(10.dp))
                                Box(modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center) {
                                    Image(painter = painterResource(
                                        id = R.drawable.contacts
                                    ),
                                        contentDescription ="home",
                                        modifier = Modifier.size(65.dp) )


                                }
                                Spacer(modifier = Modifier.height(10.dp))

                                Text(text = "Contacts",
                                    fontSize = 17.sp,
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
                            .clickable { navController.navigate(ROUT_BOOKINGS) }) {
                            Column {

                                Spacer(modifier = Modifier.height(10.dp))
                                Box(modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center) {
                                    Image(painter = painterResource(
                                        id = R.drawable.bookings
                                    ),
                                        contentDescription ="home",
                                        modifier = Modifier.size(65.dp) )


                                }
                                Spacer(modifier = Modifier.height(10.dp))

                                Text(text = "Bookings",
                                    fontSize = 17.sp,
                                    fontFamily = FontFamily.Serif,
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center
                                )

                            }
                        }
                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))



                    }
                    //End of row2

                    Row {
                        Text(
                            text = "ONLINE",
                            fontSize = 15.sp,
                            fontFamily = FontFamily.Serif,
                            modifier = Modifier.padding(top = 20.dp, start = 10.dp),
                            color = Color.Red)
                    }
                    //Row3
                    Row(modifier = Modifier.padding(20.dp)) {
                        //Card
                        Card(modifier = Modifier
                            .width(100.dp)
                            .height(120.dp)
                            .clickable { navController.navigate(ROUT_OIL) }) {
                            Column {

                                Spacer(modifier = Modifier.height(10.dp))
                                Box(modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center) {
                                    Image(painter = painterResource(
                                        id = R.drawable.website
                                    ),
                                        contentDescription ="home",
                                        modifier = Modifier.size(65.dp) )


                                }
                                Spacer(modifier = Modifier.height(10.dp))

                                Text(text = "Website",
                                    fontSize = 17.sp,
                                    fontFamily = FontFamily.Serif,
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center
                                )



                            }
                        }
                        //End of card
                        Spacer(modifier = Modifier.width(10.dp))



                    }
                    //End of row3


                }
                //End of main card


            }

            //End of main contents

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
        route="bookings",
        selectedIcon=Icons.Filled.DateRange,
        unselectedIcon=Icons.Outlined.DateRange,
        hasNews = true,
        badges=5
    ),

    BottomNavItem(
        title = "Locate Us",
        route="bookings",
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
private fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Other")
    }
}




@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}