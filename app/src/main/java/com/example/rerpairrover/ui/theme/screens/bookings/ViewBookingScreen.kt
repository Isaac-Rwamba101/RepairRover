package com.example.rerpairrover.ui.theme.screens.bookings

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.rerpairrover.data.BookingViewModel
import com.example.rerpairrover.models.Booking
import com.example.rerpairrover.navigation.ROUT_BOOKINGS
import com.example.rerpairrover.ui.theme.YellowIvy

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ViewBookingScreen(navController: NavController) {
   Column(modifier = Modifier.fillMaxSize()) {

      var context = LocalContext.current
      var bookingRepository = BookingViewModel(navController, context)


      val emptyBookingState = remember { mutableStateOf(Booking("","","","","","","")) }
      var emptyBookingListState = remember { mutableStateListOf<Booking>() }

      var bookings = bookingRepository.allBookings(emptyBookingState, emptyBookingListState)


      var selected by remember { mutableIntStateOf(0) }
      Scaffold(
         bottomBar = {
            NavigationBar (
               containerColor = YellowIvy,
               contentColor = Color.Black){
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
                                 Badge (containerColor = Color.White){
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
                     }
                  )
               }
            }
         },

         topBar = {
            TopAppBar(
               title = { Text(text = "Available Bookings",
                  modifier = Modifier.fillMaxWidth(),
                  textAlign = TextAlign.Center,
                  color = YellowIvy,
                  fontSize = 20.sp,
                  fontFamily = FontFamily.SansSerif) })

         },

         floatingActionButton = {
            FloatingActionButton(
               onClick = { navController.navigate(ROUT_BOOKINGS)},
               containerColor = YellowIvy) {
               IconButton(onClick = {
                  navController.navigate(ROUT_BOOKINGS)
               }) {
                  Icon(imageVector = Icons.Default.Add,
                     contentDescription = "menu")
               }
            }
         },
         //Content Section
         content = @Composable {
            Column(
               modifier = Modifier
                  .fillMaxSize(),
               horizontalAlignment = Alignment.CenterHorizontally
            ) {
               Text(text = "All products",
                  fontSize = 30.sp,
                  fontFamily = FontFamily.Cursive,
                  color = Color.Red)

               Spacer(modifier = Modifier.height(20.dp))

               LazyColumn(){
                  items(bookings){
                     BookingItem(
                        name = it.name,
                        service = it.service,
                        date = it.date,
                        time = it.time,
                        phone = it.phone,
                        id = it.id,
                        navController = navController,
                        bookingRepository = bookingRepository,
                        bookingImage = it.imageUrl
                     )
                  }
               }
            }

         }

      )
   }
}







@Composable
fun BookingItem(name:String, service:String, date:String,time:String, phone:String, id:String,
                navController: NavController,
                bookingRepository:BookingViewModel, bookingImage:String) {

   //1 item
   Column(modifier = Modifier
      .fillMaxWidth()
      .padding(15.dp)) {
      Card (modifier = Modifier
         .height(250.dp)
         .width(370.dp)
      ) {
         Box (modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {
            Image(
               painter = rememberAsyncImagePainter(bookingImage),
               contentDescription = "null",
               modifier = Modifier.fillMaxSize(),
               contentScale = ContentScale.Crop
            )


            Row (modifier = Modifier.align(Alignment.BottomStart)) {
               Column (modifier = Modifier
                  .background(
                     brush = Brush.verticalGradient(
                        colors = listOf(
                           Color.Transparent,
                           Color.Black
                        )
                     )
                  )
                  .fillMaxWidth()
                  .padding(7.dp)) {
                  //details

                  Text(text = "Name : $name",
                     fontSize = 27.sp,
                     fontWeight = FontWeight.ExtraBold,
                     fontFamily = FontFamily.Default,
                     color = Color.White
                  )


                  Text(text = "Service : $service",
                     fontSize = 20.sp,
                     fontWeight = FontWeight.Medium,
                     fontFamily = FontFamily.Default,
                     color = Color.White
                  )

                  Text(text = "Date : $date",
                     fontSize = 20.sp,
                     fontWeight = FontWeight.Medium,
                     fontFamily = FontFamily.Default,
                     color = Color.White
                  )

                  Spacer(modifier = Modifier.height(5.dp))

                  Text(text = "Time :$time",
                     fontSize = 19.sp,
                     fontWeight = FontWeight.Bold,
                     fontFamily = FontFamily.Default,
                     color = Color.White
                  )

                  val mContext = LocalContext.current

                  //button row
                  Row (
                     modifier = Modifier
                        .padding(bottom = 10.dp)
                        .fillMaxWidth(),
                     verticalAlignment = Alignment.CenterVertically,
                  ){
                     OutlinedButton(
                        onClick = {
                           val smsIntent= Intent(Intent.ACTION_SENDTO)
                           smsIntent.data="smsto:$phone".toUri()
                           smsIntent.putExtra("sms_body","Hello,...?")
                           mContext.startActivity(smsIntent)
                        },
                        shape = RoundedCornerShape(8.dp),

                        ) {
                        Row {
                           Icon(
                              imageVector = Icons.Default.Send,
                              contentDescription = "Message Office")
                           Spacer(modifier = Modifier.width(3.dp))
                           Text(
                              text = "Message Office"
                           )
                        }
                     }
                     Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                     ){

                        IconButton(onClick = { bookingRepository.updateBooking(id) }) {
                           Icon(imageVector = Icons.Default.Edit, contentDescription = "", tint = Color.White)
                        }

                        Spacer(modifier = Modifier.width(5.dp))

                        IconButton(onClick = { bookingRepository.deleteBooking(id) }) {
                           Icon(imageVector = Icons.Default.Delete, contentDescription = "", tint = Color.White)
                        }


                     }

                  }
                  //end of button row


                  //end details

               }
            }

         }
      }
      //end 1 item

   }
}



@Composable
@Preview(showBackground = true)
fun ViewBookingScreenPreview(){

   ViewBookingScreen(navController = rememberNavController())

}