package com.example.dailypulse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dailypulse.article.ArticlesViewModel
import com.example.dailypulse.screens.AboutScreen
import com.example.dailypulse.screens.ArticlesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val articlesViewModel : ArticlesViewModel by viewModels()

        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {

                    //AboutScreen()
                    ArticlesScreen(articlesViewModel)
                }
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    AboutScreen()
}