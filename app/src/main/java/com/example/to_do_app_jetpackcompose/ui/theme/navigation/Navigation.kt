package com.example.to_do_app_jetpackcompose.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.to_do_app_jetpackcompose.presentation.home.HomeRootScreen
import com.example.to_do_app_jetpackcompose.presentation.splash.components.SplashScreen
import kotlinx.serialization.Serializable

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SplashScreen
    ) {

        composable<SplashScreen> {
            SplashScreen(
                onContinueClick = {
                    navController.navigate(HomeScreen) {
                        popUpTo(SplashScreen) { inclusive = true }
                    }
                }
            )
        }

        composable<HomeScreen> {
            HomeRootScreen()
        }
    }
}

@Serializable
object SplashScreen

@Serializable
object HomeScreen