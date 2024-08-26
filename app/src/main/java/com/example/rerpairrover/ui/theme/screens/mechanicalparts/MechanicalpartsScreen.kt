package com.example.rerpairrover.ui.theme.screens.mechanicalparts

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
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
import com.example.rerpairrover.ui.theme.YellowIvy

@Composable
fun MechanicalpartsScreen(navController: NavController){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(YellowIvy)) {

        Text(
            text = "Mechanical Parts Servicing",
            fontSize = 40.sp,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.padding(top = 20.dp, start = 10.dp)



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
                    Text(text = "GearHeads Garage hosts a range of services covering all the fast fitment and replacement aspects of vehicle maintenance. ")
                    Spacer(modifier = Modifier.height(10.dp))
                }

                Row (modifier = Modifier.background(YellowIvy).padding(top = 20.dp)){
                    Card(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)) {

                        Box(modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .background(Color.Gray), contentAlignment = Alignment.Center){

                            Image(
                                painter = painterResource(id = com.example.rerpairrover.R.drawable.filter),
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
                            text = "Brakes",
                            fontSize = 20.sp)

                        Text(text = "FERODO and ASIMCO brakes pad sets for all vehicles and budgets with a range of discs/rotors.")
                    }

                }
                Spacer(modifier = Modifier.height(20.dp))

                Row {
                    Card(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)) {

                        Box(modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .background(Color.Gray), contentAlignment = Alignment.Center){

                            Image(
                                painter = painterResource(id = com.example.rerpairrover.R.drawable.oil),
                                contentDescription = "home",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(60.dp),
                                contentScale = ContentScale.Crop,

                                )


                        }



                    }
                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text(
                            text = "Batteries",
                            fontSize = 20.sp)

                        Text(text = "ENERGIZER,FREEBATT and BLACK TIGER BATTERIES.Warranties range from 12 to 18 months with pricing for all budgets.")
                    }

                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier.background(YellowIvy)) {
                    Card(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)) {

                        Box(modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .background(Color.Gray), contentAlignment = Alignment.Center){

                            Image(
                                painter = painterResource(id = com.example.rerpairrover.R.drawable.diagnostics),
                                contentDescription = "home",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(60.dp),
                                contentScale = ContentScale.Crop,

                                )


                        }



                    }
                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text(
                            text = "Shock Absorbers & Springs",
                            fontSize = 20.sp)

                        Text(text = "KYB shock absorbers and OBK coil springs.OBK come in heavy duty passenger springs for our road conditions.")
                    }

                }

                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    Card(modifier = Modifier.padding(top = 20.dp)) {

                        Box(modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .background(Color.Gray), contentAlignment = Alignment.Center){

                            Image(
                                painter = painterResource(id = com.example.rerpairrover.R.drawable.spark),
                                contentDescription = "home",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(60.dp),
                                contentScale = ContentScale.Crop,

                                )


                        }



                    }
                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text(
                            text = "Wiper blades",
                            fontSize = 20.sp)

                        Text(text = "BOSCH and AUTOMATE wiper blades for all vehicle types ranging from natural rubber and graphite coating to synthetic rubbers to suit all budgets.")
                    }

                }





            }
            //End of Main Card

        }

    }

}

@Composable
@Preview(showBackground = true)
fun MechanicalpartsScreenPreview(){
    MechanicalpartsScreen(rememberNavController())
}