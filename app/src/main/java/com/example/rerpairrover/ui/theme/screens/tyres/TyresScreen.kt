package com.example.rerpairrover.ui.theme.screens.tyres

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rerpairrover.navigation.ROUT_MENU
import com.example.rerpairrover.ui.theme.YellowIvy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TyresScreen(navController: NavController){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(YellowIvy)
        .verticalScroll(rememberScrollState())) {

        TopAppBar(
            title = { Text(text = "Tyres") },
            colors = TopAppBarDefaults.mediumTopAppBarColors(YellowIvy),

            navigationIcon = {
                IconButton(onClick = { navController.navigate(ROUT_MENU )}) {
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
                    .height(800.dp),
                shape = RoundedCornerShape(40.dp),
                colors = CardDefaults.cardColors(Color.White)

            ) {
                Spacer(modifier = Modifier.height(20.dp))

                Column(modifier = Modifier.padding(start = 20.dp,)) {
                    Text(text = "We carry a wide range of quality passenger,SUV and light truck tyres from the best global brands offering a solution for any budget.")
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "- Premium ")
                    Text(text = "- Mid Tier ")
                    Text(text = "- Budget ")
                    Spacer(modifier = Modifier.height(10.dp))
                }

                Row (modifier = Modifier
                    .background(YellowIvy)
                    .fillMaxWidth()
                    .padding(top = 20.dp)){
                    Card(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)) {

                        Box(modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .background(Color.Gray), contentAlignment = Alignment.Center){

                            Image(
                                painter = painterResource(id = com.example.rerpairrover.R.drawable.pct),
                                contentDescription = "home",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(60.dp),
                                contentScale = ContentScale.Crop,

                                )


                        }



                    }
                    Spacer(modifier = Modifier.width(20.dp))

                    Column(modifier = Modifier.padding(top = 30.dp)) {
                        Text(
                            text = "Passenger car tyres",
                            fontSize = 20.sp)

                        Text(text = "For urban, sport touring, high performance and ultra high-performance road tyres.")
                    }

                }
                Spacer(modifier = Modifier.height(20.dp))

                Row(modifier = Modifier
                    .fillMaxWidth()) {
                    Card(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)) {

                        Box(modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .background(Color.Gray), contentAlignment = Alignment.Center){

                            Image(
                                painter = painterResource(id = com.example.rerpairrover.R.drawable.suv),
                                contentDescription = "home",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(60.dp),
                                contentScale = ContentScale.Crop,

                                )


                        }



                    }
                    Spacer(modifier = Modifier.width(20.dp))

                    Column(modifier = Modifier.padding(top = 20.dp)) {
                        Text(
                            text = "SUV/4x4 tyres",
                            fontSize = 20.sp)

                        Text(text = "Covering the full spectrum Highway terrain,All-Terrain,Advanced All-Terrain and Mud-Terrain applications.")
                    }

                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier
                    .background(YellowIvy)
                    .fillMaxWidth()) {
                    Card(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)) {

                        Box(modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .background(Color.Gray), contentAlignment = Alignment.Center){

                            Image(
                                painter = painterResource(id = com.example.rerpairrover.R.drawable.truck),
                                contentDescription = "home",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(60.dp),
                                contentScale = ContentScale.Crop,

                                )


                        }



                    }
                    Spacer(modifier = Modifier.width(20.dp))

                    Column(modifier = Modifier.padding(top = 20.dp)) {
                        Text(
                            text = "Light truck tyres",
                            fontSize = 20.sp)

                        Text(text = "For taxi vans and pick-up trucks for commercial applications.")
                    }

                }







            }
            //End of Main Card

        }

    }

}

@Composable
@Preview(showBackground = true)
fun TyresScreenPreview(){
    TyresScreen(rememberNavController())
}