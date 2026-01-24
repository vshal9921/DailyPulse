package com.example.dailypulse

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dailypulse.article.ArticlesViewModel
import com.example.dailypulse.screens.AboutScreen
import com.example.dailypulse.screens.ArticlesScreen
import com.example.dailypulse.screens.Screen

@Composable
fun AppScaffold(articlesViewModel: ArticlesViewModel) {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            articlesViewModel
        )

    }
}

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier, viewModel: ArticlesViewModel) {

    NavHost(
        navController = navController,
        startDestination = Screen.ARTICLES.route,
        modifier = modifier
    ){

        composable(Screen.ARTICLES.route){
            ArticlesScreen(
                onAboutClick = {navController.navigate(Screen.ABOUT_DEVICE.route)},
                articlesViewModel = viewModel
            )
        }

        composable(Screen.ABOUT_DEVICE.route){
            AboutScreen(
                onBackPress = { navController.popBackStack() }
            )
        }
    }
}