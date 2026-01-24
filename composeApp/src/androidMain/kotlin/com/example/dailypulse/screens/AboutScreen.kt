package com.example.dailypulse.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.dailypulse.Platform

@Composable
fun AboutScreen(
    onBackPress:()-> Unit
) {
    Column {
        Toolbar(onBackPress)
        AboutContentView()
    }
}

@Composable
private fun AboutContentView() {

    val items = makeItems()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items){
            RowView(title = it.first, subtitle = it.second)
        }
    }
}

@Composable
private fun RowView(title: String, subtitle: String) {
    Column (modifier = Modifier.padding(8.dp)){
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
        HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
    }
}

private fun makeItems(): List<Pair<String, String>> {

    val platform = Platform()
    platform.logSystemInfo()

    return listOf(
        Pair("Operating System", "${platform.osName} ${platform.osVersion}"),
        Pair("Device", platform.deviceModel),
        Pair("Density", platform.density.toString())
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(onBackPress: () -> Unit) {
    TopAppBar(
        title = { Text("About Screen") },
        navigationIcon = {
            IconButton(onBackPress) {
                Icon(imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "Back")
            }
        }
    )
}
