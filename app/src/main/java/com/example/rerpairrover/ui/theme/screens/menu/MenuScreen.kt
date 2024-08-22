package com.example.rerpairrover.ui.theme.screens.menu

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MenuScreen(navController: NavController){

    //Navigation Drawer

    val drawerState = rememberDrawerState(DrawerValue.Closed)

    val scope = rememberCoroutineScope()

    val menuList = listOf(
        Icons.Filled.Home to "Home" ,
        Icons.Filled.Favorite to "Contacts" ,
        Icons.Filled.Info to "History",
        Icons.Filled.Settings to "Settings",
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
            topBar = {

                TopAppBar(title = { Text(text = "Homepage") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = "")
                        }
                    })

            }
        ) {


            //Main Content of the screen

            Column (modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp),
                horizontalAlignment = Alignment.CenterHorizontally){

                Text(text = "This is current page", fontSize = 20.sp)

                Text(
                    text = "EstatePlus payment platform",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(10.dp))



                Text(
                    text = "Manage your properties with ease!",
                    fontSize = 18.sp
                )


            }

            //End of main contents

        }


    }


}





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
fun MenuScreenPreview(){
    MenuScreen(rememberNavController())
}