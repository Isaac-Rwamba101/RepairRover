package com.example.rerpairrover.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.repairrover.ui.theme.screens.signup.SignupScreen
import com.example.rerpairrover.ui.theme.screens.about.AboutScreen
import com.example.rerpairrover.ui.theme.screens.accessories.AccessoriesScreen
import com.example.rerpairrover.ui.theme.screens.admin.AdminScreen
import com.example.rerpairrover.ui.theme.screens.bookings.AddBookingsScreen
import com.example.rerpairrover.ui.theme.screens.contacts.ContactsScreen
import com.example.rerpairrover.ui.theme.screens.home.HomeScreen
import com.example.rerpairrover.ui.theme.screens.location.LocationScreen
import com.example.rerpairrover.ui.theme.screens.login.LoginScreen
import com.example.rerpairrover.ui.theme.screens.mechanicalparts.MechanicalpartsScreen
import com.example.rerpairrover.ui.theme.screens.notifications.NotificationsScreen
import com.example.rerpairrover.ui.theme.screens.oilservice.OilserviceScreen
import com.example.rerpairrover.ui.theme.screens.settings.SettingsScreen
import com.example.rerpairrover.ui.theme.screens.splash.SplashScreen
import com.example.rerpairrover.ui.theme.screens.tyres.TyresScreen
import com.example.rerpairrover.ui.theme.screens.reviews.UploadScreen
import com.example.rerpairrover.ui.theme.screens.reviews.ViewScreen
import com.example.rerpairrover.ui.theme.screens.bookings.ViewBookingScreen
import com.example.rerpairrover.ui.theme.screens.website.WebsiteScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination:String = ROUT_SPLASH
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {


        composable(ROUT_ABOUT) {
            AboutScreen(navController = navController)
        }

        composable(ROUT_SPLASH) {
            SplashScreen(navController = navController)
        }

        composable(ROUT_SIGNUP) {
            SignupScreen(navController = navController)
        }

        composable(ROUT_LOGIN) {
            LoginScreen(navController = navController)
        }

        composable(ROUT_SETTINGS) {
            SettingsScreen(navController = navController)
        }

        composable(ROUT_HOME) {
           HomeScreen(navController = navController)
        }

        composable(ROUT_OIL) {
            OilserviceScreen(navController = navController)
        }

        composable(ROUT_TYRES) {
            TyresScreen(navController = navController)
        }

        composable(ROUT_MECHANICAL) {
            MechanicalpartsScreen(navController = navController)
        }

        composable(ROUT_ACCESSORIES) {
            AccessoriesScreen(navController = navController)
        }

        composable(ROUT_CONTACTS) {
            ContactsScreen(navController = navController)
        }

        composable(ROUT_BOOKINGS) {
           AddBookingsScreen(navController = navController)
        }

        composable(ROUT_VIEWBOOKINGS) {
            ViewBookingScreen(navController = navController)
        }

        composable(ROUT_NOTIFICATIONS) {
           NotificationsScreen(navController = navController)
        }

        composable(ROUT_LOCATION) {
            LocationScreen(navController = navController)
        }

        composable(ROUT_UPLOAD) {
           UploadScreen(navController = navController)
        }

        composable(ROUT_VIEW) {
            ViewScreen(navController = navController)
        }

        composable(ROUT_ADMIN) {
            AdminScreen(navController = navController)
        }

        composable(ROUT_WEBSITE) {
            WebsiteScreen(navController = navController)
        }




    }
}

