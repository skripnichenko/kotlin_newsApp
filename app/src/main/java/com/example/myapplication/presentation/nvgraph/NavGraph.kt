package com.example.myapplication.presentation.nvgraph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.presentation.Route
import com.example.myapplication.presentation.onboarding.OnBoardingScreen
import com.example.myapplication.presentation.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.HomeScreen.route
        ) {
            composable(route = Route.HomeScreen.route) {
                Text(text = "Screen")
            }
            composable(route = Route.SearchScreen.route) {
                Text(text = "Screen")
            }
            composable(route = Route.BookmarkScreen.route) {
                Text(text = "Screen")
            }
            composable(route = Route.DetailsScreen.route) {
                Text(text = "Screen")
            }
        }
    }
}