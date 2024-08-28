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
import com.example.rerpairrover.ui.theme.screens.bookings.BookingsScreen
import com.example.rerpairrover.ui.theme.screens.contacts.ContactsScreen
import com.example.rerpairrover.ui.theme.screens.home.HomeScreen
import com.example.rerpairrover.ui.theme.screens.login.LoginScreen
import com.example.rerpairrover.ui.theme.screens.mechanicalparts.MechanicalpartsScreen
import com.example.rerpairrover.ui.theme.screens.notifications.NotificationsScreen
import com.example.rerpairrover.ui.theme.screens.oilservice.OilserviceScreen
import com.example.rerpairrover.ui.theme.screens.settings.SettingsScreen
import com.example.rerpairrover.ui.theme.screens.splash.SplashScreen
import com.example.rerpairrover.ui.theme.screens.tyres.TyresScreen

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
           BookingsScreen(navController = navController)
        }

        composable(ROUT_NOTIFICATIONS) {
           NotificationsScreen(navController = navController)
        }




    }
}

