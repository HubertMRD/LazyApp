package com.example.lazyimageapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.lazyimageapp.ui.theme.LazyImageAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyImageAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LazyApp(modifier: Modifier = Modifier) {

    val orientation = LocalConfiguration.current.orientation

    if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
        LazyLandscape(modifier)
    } else {
        LazyPortrait(modifier)
    }
}

@Composable
fun LazyPortrait(modifier: Modifier = Modifier) {

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(20) {
            Image(
                painter = painterResource(id = R.drawable.image1),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun LazyLandscape(modifier: Modifier = Modifier) {

    LazyRow(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(20) {
            Image(
                painter = painterResource(id = R.drawable.image1),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .padding(8.dp)
            )
        }
    }
}





