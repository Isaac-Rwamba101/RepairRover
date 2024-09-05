package com.example.rerpairrover.ui.theme.screens.accessories

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rerpairrover.data.AuthViewModel
import com.example.rerpairrover.navigation.ROUT_HOME
import com.example.rerpairrover.ui.theme.YellowIvy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccessoriesScreen(navController: NavController){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(YellowIvy)) {

        TopAppBar(
            title = { Text(text = "Accessories") },
            colors = TopAppBarDefaults.mediumTopAppBarColors(YellowIvy),

            navigationIcon = {
                IconButton(onClick = { navController.navigate(ROUT_HOME)}) {
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
                    .height(1350.dp)
                    .verticalScroll(rememberScrollState()),
                shape = RoundedCornerShape(40.dp),
                colors = CardDefaults.cardColors(Color.White)

            ) {
                Spacer(modifier = Modifier.height(20.dp))

                Column(modifier = Modifier.padding(start = 20.dp,)) {
                    Text(text = "In addition to the tyre,service and mechanical parts, GearHeads Garage carries a range of automotive accessories for your vehicle and garage to give them that Xtra-bling and a fresh new look. ")
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "The available categories and brands may differ from country to country.")
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "This range is made up of various categories:")
                    Spacer(modifier = Modifier.height(10.dp))

                    val context = LocalContext.current
                    val authViewModel = AuthViewModel(navController, context)
                    Button(onClick = { navController.navigate(ROUT_HOME) },

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 20.dp, end = 20.dp),
                        colors = ButtonDefaults.buttonColors(YellowIvy),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(text = "More")

                    }
                    Spacer(modifier = Modifier.height(10.dp))

                }

                Row (modifier = Modifier
                    .background(YellowIvy)
                    .fillMaxWidth()
                    .padding(top = 20.dp)){
                    Card(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp,start = 5.dp)) {

                        Box(modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .background(Color.Gray), contentAlignment = Alignment.Center){

                            Image(
                                painter = painterResource(id = com.example.rerpairrover.R.drawable.carcare),
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
                            text = "Car Care",
                            fontSize = 20.sp)

                        Text(text = "Polishes and cleaners")
                        Text(text = "Sponges,micro fibre cloths & chamois.")
                    }

                }
                Spacer(modifier = Modifier.height(20.dp))

                Row (modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()){
                    Card(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp,start = 5.dp)) {

                        Box(modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .background(Color.Gray), contentAlignment = Alignment.Center){

                            Image(
                                painter = painterResource(id = com.example.rerpairrover.R.drawable.fashion),
                                contentDescription = "home",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(60.dp),
                                contentScale = ContentScale.Crop,

                                )


                        }



                    }
                    Spacer(modifier = Modifier.width(20.dp))

                    Column(modifier = Modifier.padding(top = 20.dp))  {
                        Text(
                            text = "Fashion",
                            fontSize = 20.sp)

                        Text(text = "Rubber mats, car seat cover sets and steering wheel covers.")
                    }

                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier
                    .background(YellowIvy)
                    .fillMaxWidth()) {
                    Card(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp,start = 5.dp)) {

                        Box(modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .background(Color.Gray), contentAlignment = Alignment.Center){

                            Image(
                                painter = painterResource(id = com.example.rerpairrover.R.drawable.airfreshener),
                                contentDescription = "home",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(60.dp),
                                contentScale = ContentScale.Crop,

                                )


                        }



                    }
                    Spacer(modifier = Modifier.width(20.dp))

                    Column(modifier = Modifier.padding(top = 20.dp))  {
                        Text(
                            text = "Air Fresheners",
                            fontSize = 20.sp)

                        Text(text = "Air vent,gel cups & hanging fresheners as well as dashboard sprays.")
                    }

                }

                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()) {
                    Card(modifier = Modifier.padding(top = 20.dp,start = 5.dp)) {

                        Box(modifier = Modifier
                            .height(100.dp)
                            .width(100.dp)
                            .background(Color.Gray), contentAlignment = Alignment.Center){

                            Image(
                                painter = painterResource(id = com.example.rerpairrover.R.drawable.travel),
                                contentDescription = "home",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(60.dp),
                                contentScale = ContentScale.Crop,

                                )


                        }



                    }
                    Spacer(modifier = Modifier.width(20.dp))

                    Column(modifier = Modifier.padding(top = 20.dp))  {
                        Text(
                            text = "Travel",
                            fontSize = 20.sp)

                        Text(text = "Tow ropes & compressors")
                        Text(text = "Battery booster cables & jump starters.")
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
                                painter = painterResource(id = com.example.rerpairrover.R.drawable.safety),
                                contentDescription = "home",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(60.dp),
                                contentScale = ContentScale.Crop,

                                )


                        }



                    }
                    Spacer(modifier = Modifier.width(20.dp))

                    Column(modifier = Modifier.padding(top = 20.dp))  {
                        Text(
                            text = "Safety",
                            fontSize = 20.sp)

                        Text(text = "First aid kits & Fire extinguishers")
                        Text(text = "Warning triangles")
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
                                painter = painterResource(id = com.example.rerpairrover.R.drawable.garage),
                                contentDescription = "home",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(60.dp),
                                contentScale = ContentScale.Crop,

                                )


                        }



                    }
                    Spacer(modifier = Modifier.width(20.dp))

                    Column(modifier = Modifier.padding(top = 20.dp))  {
                        Text(
                            text = "Garage",
                            fontSize = 20.sp)

                        Text(text = "Bottle & trolley jacks and trestle strands.")

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
                                painter = painterResource(id = com.example.rerpairrover.R.drawable.gadgets),
                                contentDescription = "home",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(60.dp),
                                contentScale = ContentScale.Crop,

                                )


                        }



                    }
                    Spacer(modifier = Modifier.width(20.dp))

                    Column(modifier = Modifier.padding(top = 20.dp))  {
                        Text(
                            text = "Gadgets",
                            fontSize = 20.sp)

                        Text(text = "DVR cameras,bluetooth radio connectors and mobile phones accessories. ")

                    }

                }
                Spacer(modifier = Modifier.height(20.dp))





            }
            //End of Main Card

        }

    }

}

@Composable
@Preview(showBackground = true)
fun AccessoriesScreenPreview(){
    AccessoriesScreen(rememberNavController())
}