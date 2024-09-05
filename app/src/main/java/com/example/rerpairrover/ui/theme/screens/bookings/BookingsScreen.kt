package com.example.rerpairrover.ui.theme.screens.bookings

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rerpairrover.data.BookingViewModel
import com.example.rerpairrover.navigation.ROUT_HOME
import com.example.rerpairrover.ui.theme.Orange
import com.example.rerpairrover.ui.theme.YellowIvy
import java.util.Calendar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddBookingsScreen(navController:NavHostController){
   Column(
      modifier = Modifier
         .fillMaxSize()
         .background(YellowIvy)
      ,
      horizontalAlignment = Alignment.CenterHorizontally
   ) {

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
               title = { Text(
                  text = "Bookings",
                  fontFamily = FontFamily.SansSerif,
                  fontSize = 30.sp) },
               colors = TopAppBarDefaults.mediumTopAppBarColors(YellowIvy),


               navigationIcon = {
                  IconButton(onClick = { navController.navigate(ROUT_HOME )}) {
                     Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "menu",)

                  }
               },

               )
         },



         //Content Section
         content = @Composable{
            Column(
               modifier = Modifier
                  .fillMaxSize()
                  .padding(top = 100.dp)

               ,
               horizontalAlignment = Alignment.CenterHorizontally
            ) {

               Card(
                  modifier = Modifier
                     .fillMaxWidth()
                     .verticalScroll(rememberScrollState())
                     .height(1250.dp)
                     .clickable { navController.navigate(ROUT_HOME) },
                  shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                  colors = CardDefaults.cardColors(Color.White)

               ) {


                  //End of Main Card


                  Spacer(modifier = Modifier.height(50.dp))

                  Text(
                     modifier =Modifier.padding(start = 30.dp, bottom = 20.dp),
                     text = "Upload Required Service Here!",
                     fontSize = 20.sp,
                     fontWeight = FontWeight.Bold,
                     fontFamily = FontFamily.SansSerif,

                  )

                  var name by remember { mutableStateOf("") }
                  var service by remember { mutableStateOf("") }
                  var time by remember { mutableStateOf("") }
                  var phone by remember { mutableStateOf("") }
                  val context = LocalContext.current

                  Spacer(modifier = Modifier.height(10.dp))


                  Text(
                     modifier =Modifier.padding(20.dp),
                     text = "Your Name",
                     fontSize = 18.sp,
                     fontWeight = FontWeight.Bold,
                     fontFamily = FontFamily.SansSerif
                  )

                  OutlinedTextField(
                     value = name,
                     onValueChange = { name = it },
                     label = { Text(text = "e.g Isaac ") },
                     keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                     modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                  )

                  Spacer(modifier = Modifier.height(10.dp))

                  Text(
                     modifier =Modifier.padding(20.dp),
                     text = "Name of Service",
                     fontSize = 18.sp,
                     fontWeight = FontWeight.Bold,
                     fontFamily = FontFamily.SansSerif
                  )

                  // Start of Text Field with a dropdown
                  var mExpanded by remember { mutableStateOf(false) }
                  val options = listOf("Oil Maintenance", "Accessories", "Tyre Change")
                  var mTextFieldSize by remember { mutableStateOf(Size.Zero) }
                  val icon =
                     if (mExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown

                  Column(Modifier.padding(20.dp)) {
                     OutlinedTextField(
                        value = service,
                        onValueChange = { service = it },
                        modifier = Modifier
                           .fillMaxWidth()
                           .onGloballyPositioned { coordinates ->
                              mTextFieldSize = coordinates.size.toSize()
                           },
                        label = { Text("Choose type of service") },
                        trailingIcon = {
                           Icon(icon, "contentDescription",
                              Modifier.clickable { mExpanded = !mExpanded })
                        }
                     )
                     DropdownMenu(
                        expanded = mExpanded,
                        onDismissRequest = { mExpanded = false },
                        modifier = Modifier.width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
                     ) {
                        options.forEach {

                              label ->
                           DropdownMenuItem(
                              text = { Text(text = label) },
                              onClick = {
                                 service = label
                                 mExpanded = false
                              })


                        }
                     }
                  }
                  //End of TextField with dropdown


                  Spacer(modifier = Modifier.height(10.dp))


                  //DateField
                  var selectedDate by remember { mutableStateOf("") }
                  var showDatePicker by remember { mutableStateOf(false) }



                  Row(modifier = Modifier.padding(start = 20.dp, end = 20.dp)){

                     Button(onClick = {
                        val calendar = Calendar.getInstance()
                        val year = calendar.get(Calendar.YEAR)
                        val month = calendar.get(Calendar.MONTH)
                        val day = calendar.get(Calendar.DAY_OF_MONTH)

                        DatePickerDialog(
                           //Don't forget to create the context variable located just below
                           //the aboutscreen function
                           context,
                           { _, selectedYear, selectedMonth, selectedDay ->
                              selectedDate = "${selectedDay}/${selectedMonth + 1}/${selectedYear}"
                           },
                           year,
                           month,
                           day
                        ).show()
                     },
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(Orange),
                        modifier = Modifier
                           .height(65.dp)
                           .padding(top = 10.dp)) {
                        Text(text = "Appointment Date")
                     }
                     Spacer(modifier = Modifier.width(20.dp))

                     OutlinedTextField(
                        value = selectedDate ?: "",
                        onValueChange = { /* No-op, as we handle value through date picker */ },
                        label = { Text("Select Date") },
                        readOnly = true,  // Makes the text field non-editable
                        modifier = Modifier
                           .padding(bottom = 16.dp)
                           .width(250.dp),
                        trailingIcon = {
                           Text(text = "📅")  // Icon to indicate date picker
                        },
                        singleLine = true
                     )


                  }

                  //End of a datefield

                  Spacer(modifier = Modifier.height(20.dp))


                  Text(
                     modifier =Modifier.padding(20.dp),
                     text = "Exact Time of Service",
                     fontSize = 18.sp,
                     fontWeight = FontWeight.Bold,
                     fontFamily = FontFamily.SansSerif
                  )

                  OutlinedTextField(
                     value = time,
                     onValueChange = { time = it },
                     label = { Text(text = "e.g 9:00 a.m") },
                     keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                     modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                  )

                  Spacer(modifier = Modifier.height(20.dp))

                  Text(
                     modifier =Modifier.padding(20.dp),
                     text = "Phone Number",
                     fontSize = 18.sp,
                     fontWeight = FontWeight.Bold,
                     fontFamily = FontFamily.SansSerif
                  )

                  Spacer(modifier = Modifier.height(20.dp))

                  OutlinedTextField(
                     value = phone,
                     onValueChange = { phone = it },
                     label = { Text(text = "Phone") },
                     keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                     modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                  )

                  Spacer(modifier = Modifier.height(20.dp))


                  //---------------------IMAGE PICKER START-----------------------------------//

                  var modifier = Modifier
                  ImagePicker(
                     modifier,
                     context,
                     navController,
                     name.trim(),
                     service.trim(),
                     selectedDate.trim(),
                     time.trim(),
                     phone.trim(),
                  )

                  //---------------------IMAGE PICKER END-----------------------------------//


               }

            }


         }
      )





   }
}




val bottomNavItems = listOf(
   BottomNavItem(
      title = "Home",
      route="home",
      selectedIcon= Icons.Filled.Home,
      unselectedIcon= Icons.Outlined.Home,
      hasNews = false,
      badges=0
   ),

   BottomNavItem(
      title = "View",
      route="viewbookings",
      selectedIcon=Icons.Filled.Info,
      unselectedIcon=Icons.Outlined.Info,
      hasNews = false,
      badges=0
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
fun ImagePicker(modifier: Modifier = Modifier, context: Context,navController: NavHostController, name:String, service:String,date:String,time:String,phone:String) {
   var hasImage by remember { mutableStateOf(false) }
   var imageUri by remember { mutableStateOf<Uri?>(null) }

   val imagePicker = rememberLauncherForActivityResult(
      contract = ActivityResultContracts.GetContent(),
      onResult = { uri ->
         hasImage = uri != null
         imageUri = uri
      }
   )

   Column(modifier = modifier,) {
      if (hasImage && imageUri != null) {
         val bitmap = MediaStore.Images.Media.
         getBitmap(context.contentResolver,imageUri)
         Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
            Image(bitmap = bitmap.asImageBitmap(),
               contentDescription = "Selected image",
               modifier = Modifier
                  .size(100.dp)
                  .clip(CircleShape),
               contentScale = ContentScale.Crop)
         }
      }
      Column(
         modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp), horizontalAlignment = Alignment.CenterHorizontally,) {
         Button(
            onClick = {
               imagePicker.launch("image/*")
            },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(Orange)
         ) {
            Text(
               text = "Select Image"
            )
         }

         Spacer(modifier = Modifier.height(20.dp))

         Button(onClick = {
            //-----------WRITE THE UPLOAD LOGIC HERE---------------//
            var bookingRepository = BookingViewModel(navController,context)
            bookingRepository.uploadBooking(name,service,date,time,phone,imageUri!!)


         },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(Color.Red)) {
            Text(text = "Upload")
         }

         Spacer(modifier = Modifier.height(150.dp))

      }
   }
}

@Composable
@Preview(showBackground = true)
fun AddBookingsScreenPreview(){
   AddBookingsScreen(navController = rememberNavController())

}



