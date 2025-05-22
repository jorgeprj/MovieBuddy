package com.seuprojeto.mymovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.seuprojeto.mymovie.navigation.Screen
import com.seuprojeto.mymovie.theme.MyMovieTheme
import com.seuprojeto.mymovie.ui.details.DetailsScreen
import com.seuprojeto.mymovie.ui.home.HomeScreen
import com.seuprojeto.mymovie.ui.login.LoginScreen
import com.seuprojeto.mymovie.ui.search.SearchScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMovieTheme {
                Surface {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.Login.route) {
                        composable(Screen.Login.route) {
                            LoginScreen(onLoginSuccess = {
                                navController.navigate(Screen.Home.route) {
                                    popUpTo(Screen.Login.route) { inclusive = true }
                                }
                            })
                        }
                        composable(Screen.Home.route) {
                            HomeScreen(
                                onNavigateToLogin = {
                                    navController.navigate(Screen.Login.route) {
                                        popUpTo(Screen.Home.route) { inclusive = true }
                                    }
                                },
                                onNavigateToSearch = {
                                    navController.navigate(Screen.Search.route)
                                },
                                onNavigateToDetails = { movieId ->
                                    navController.navigate(Screen.Details.createRoute(movieId))
                                }
                            )
                        }
                        composable(Screen.Search.route) {
                            SearchScreen(
                                onNavigateToHome = { navController.navigate(Screen.Home.route) },
                                onNavigateToLogin = {
                                    navController.navigate(Screen.Login.route) {
                                        popUpTo(Screen.Search.route) { inclusive = true }
                                    }
                                }
                            )
                        }
                        composable(
                            route = Screen.Details.route,
                            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val movieId = backStackEntry.arguments?.getInt("movieId") ?: 0
                            DetailsScreen(
                                movieId = movieId,
                                onNavigateToHome = { navController.navigate(Screen.Home.route) }
                            )
                        }
                    }
                }
            }
        }
    }
}