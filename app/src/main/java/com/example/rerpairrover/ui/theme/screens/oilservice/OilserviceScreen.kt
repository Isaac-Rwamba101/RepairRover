package com.example.rerpairrover.ui.theme.screens.oilservice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Favorite
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
import com.example.rerpairrover.navigation.ROUT_HOME
import com.example.rerpairrover.ui.theme.YellowIvy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OilserviceScreen(navController: NavController){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(YellowIvy)) {

        TopAppBar(
            title = { Text(
                text = "Oil Service",
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
                    .height(900.dp)
                    .verticalScroll(rememberScrollState()),
                shape = RoundedCornerShape(40.dp),
                colors = CardDefaults.cardColors(Color.White)

            ) {
                Spacer(modifier = Modifier.height(20.dp))

                Column(modifier = Modifier.padding(start = 20.dp,)) {
                    Text(text = "GearHeads Garage offers a full oil service. Our oil service includes the replacement of used engine oil and filter and periodic replacement of the air filter and spark plugs.")
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "The full service includes an electronic diagnostics reset if need be.")
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

                    Column(modifier = Modifier.padding(top = 20.dp)) {
                        Text(
                            text = "Filtration",
                            fontSize = 20.sp)

                        Text(text = "Oil and filter replacement using premium products from Bosch, one of the world's largest automotive brands.")
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

                    Column(modifier = Modifier.padding(top = 20.dp)) {
                        Text(
                            text = "Lubrication",
                            fontSize = 20.sp)

                        Text(text = "Mineral and synthetic oil for petrol and diesel vehicles.")
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

                    Column(modifier = Modifier.padding(top = 20.dp)) {
                        Text(
                            text = "Diagnostics",
                            fontSize = 20.sp)

                        Text(text = "Electronic and service resets utilising modern diagnostics equipment from Launch Industries.")
                    }

                }

                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()) {
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

                    Column(modifier = Modifier.padding(top = 20.dp)) {
                        Text(
                            text = "Spark Plugs",
                            fontSize = 20.sp)

                        Text(text = "Spark plug replacement from the NGK the largest manufacturer and OEM supplier.")
                    }

                }





            }
            //End of Main Card

        }

    }

}

@Composable
@Preview(showBackground = true)
fun OilserviceScreenPreview(){
    OilserviceScreen(rememberNavController())
}