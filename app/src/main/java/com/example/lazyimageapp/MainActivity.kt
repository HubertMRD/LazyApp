package com.example.lazyimageapp

import android.R.attr.name
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazyimageapp.ui.theme.LazyImageAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyImageAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LazyApp(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val names = 2
        items(names) { img ->
            Text(
                text = ("$img"),
                modifier = Modifier
                    .padding(3.dp)
            )
        }

        item{
            Text(
                text = "END",
                modifier = Modifier
                    .padding(3.dp)
            )
        }
    }

}
