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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
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
import com.example.rerpairrover.navigation.ROUT_HOME
import com.example.rerpairrover.ui.theme.YellowIvy

@Composable
fun SettingsScreen(navController: NavController){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(YellowIvy),
        ) {

        Text(
            text = "Settings",
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
fun SettingsScreenPreview(){
    SettingsScreen(rememberNavController())
}