package com.example.rerpairrover.ui.theme.screens.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rerpairrover.R
import com.example.rerpairrover.navigation.ROUT_ABOUT
import com.example.rerpairrover.navigation.ROUT_HOME
import com.example.rerpairrover.navigation.ROUT_WEBSITE
import com.example.rerpairrover.ui.theme.Orange
import com.example.rerpairrover.ui.theme.YellowIvy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(YellowIvy),
        ) {

        TopAppBar(
            title = { Text(
                text = "Settings",
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

                Spacer(modifier = Modifier.height(10.dp))
                //Card
                Card(modifier = Modifier
                    .padding(start = 20.dp, top = 40.dp)
                    .width(250.dp)
                    .height(50.dp)
                    .clickable { navController.navigate(ROUT_ABOUT) }) {
                    Column(modifier = Modifier.background(Orange)) {

                        Spacer(modifier = Modifier.height(10.dp))

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(text = "About Us",
                            fontSize = 20.sp,
                            fontFamily = FontFamily.Serif,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )



                    }
                }
                //End of card


            }
            //End of Main Card

        }

    }

}

@Composable
@Preview(showBackground = true)
fun SettingsScreenPreview(){
    SettingsScreen(rememberNavController())
}