package com.example.dailypulse.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.dailypulse.article.Article
import com.example.dailypulse.article.ArticlesViewModel

@Composable
fun ArticlesScreen(
    onAboutClick: () -> Unit,
    articlesViewModel: ArticlesViewModel
){

    val articlesState = articlesViewModel.articlesState.collectAsState()

    Column {

        AppBar(onAboutClick)

        if(articlesState.value.loading){
            Loader()
        }

        if(articlesState.value.error != null){
            ErrorMessage(articlesState.value.error!!)
        }

        if(articlesState.value.articles.isNotEmpty()){
            ArticlesListView(articlesState.value.articles)
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(onAboutClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Articles") },
        actions = {
            IconButton(onClick = onAboutClick) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "About"
                )
            }
        }
    )
}

@Composable
fun Loader(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){

        CircularProgressIndicator(
            modifier = Modifier.size(64.dp),
            color = MaterialTheme.colorScheme.surfaceTint,
            trackColor = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun ErrorMessage(message: String){
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(
            text = message,
            style = TextStyle(fontSize = 24.sp, textAlign = TextAlign.Center)
        )
    }
}

@Composable
fun ArticlesListView(articles: List<Article>) {

    LazyColumn (modifier = Modifier.fillMaxSize()){
        items(articles){ article ->
            ArticleItemView(article)
        }
    }
}

@Composable
fun ArticleItemView(article: Article) {

    Column (
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)){

        AsyncImage(
            model = article.imageUrl,
            contentDescription = article.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = article.title,
            style = TextStyle(fontSize = 27.sp, fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = article.description)

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = article.date,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(4.dp))

    }
}