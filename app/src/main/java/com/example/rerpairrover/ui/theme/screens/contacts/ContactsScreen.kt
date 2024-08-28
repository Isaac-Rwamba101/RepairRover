package com.example.rerpairrover.ui.theme.screens.contacts

import android.content.Intent
import android.provider.MediaStore
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rerpairrover.navigation.ROUT_HOME
import com.example.rerpairrover.ui.theme.Orange
import com.example.rerpairrover.ui.theme.YellowIvy

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsScreen(navController: NavController){

   Column(modifier = Modifier
      .fillMaxSize()
      .background(YellowIvy)) {

      TopAppBar(
         title = { Text(text = "Contacts") },
         colors = TopAppBarDefaults.mediumTopAppBarColors(YellowIvy),

         navigationIcon = {
            IconButton(onClick = { navController.navigate(ROUT_HOME)}) {
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

            val mContext = LocalContext.current


            Spacer(modifier = Modifier.height(20.dp))



            //CALL
            Button(onClick = {
               val callIntent= Intent(Intent.ACTION_DIAL)
               callIntent.data="tel:0795335461".toUri()
               mContext.startActivity(callIntent)
            },
               modifier = Modifier
                  .size(width = 380.dp, height = 70.dp)
                  .fillMaxWidth()
                  .padding(start = 20.dp, end = 20.dp, top = 20.dp),
               shape = CutCornerShape(5.dp),
               colors = ButtonDefaults.buttonColors(Orange)
            ) {
               Text(text = "Call")
            }







            Spacer(modifier = Modifier.height(20.dp))


            //SMS
            Button(onClick = {
               val smsIntent= Intent(Intent.ACTION_SENDTO)
               smsIntent.data="smsto:0795335461".toUri()
               smsIntent.putExtra("sms_body","Hello Glory,how was your day?")
               mContext.startActivity(smsIntent)
            },
               modifier = Modifier
                  .fillMaxWidth()
                  .height(50.dp)
                  .padding(start = 20.dp, end = 20.dp),
               colors = ButtonDefaults.buttonColors(Orange),
               shape = RoundedCornerShape(10.dp)
            ) {
               Text(text = "SMS")

            }

            Spacer(modifier = Modifier.height(20.dp))


            //EMAIL
            Button(onClick = {
               val shareIntent = Intent(Intent.ACTION_SEND)
               shareIntent.type = "text/plain"
               shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("isaacrwamba019@gmail.com"))
               shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
               shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
               mContext.startActivity(shareIntent)
            },
               modifier = Modifier
                  .fillMaxWidth()
                  .height(50.dp)
                  .padding(start = 20.dp, end = 20.dp),
               colors = ButtonDefaults.buttonColors(Orange),
               shape = RoundedCornerShape(10.dp)
            ) {
               Text(text = "Email")

            }

            Spacer(modifier = Modifier.height(20.dp))



            Spacer(modifier = Modifier.height(20.dp))




         }

      }

   }

}

@Composable
@Preview(showBackground = true)
fun ContactsScreenPreview(){
   ContactsScreen(rememberNavController())
}