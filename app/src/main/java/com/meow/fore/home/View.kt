package com.meow.fore.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeScreenViewModel: HomeScreenViewModel? = null
) {
    val viewState = homeScreenViewModel?.viewState ?: HomeScreenViewState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "Welcome to Fore!",
            style = MaterialTheme.typography.displaySmall,
            color = Color.Black
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "Title",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = "Subheading about this section",
            style = MaterialTheme.typography.bodyMedium,
        )
        LazyRow(content = {
            items(12) {
                TitleItem(
                    title = "Title",
                    description = "Description"
                )
            }
        })
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "Title",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = "Subheading about this section",
            style = MaterialTheme.typography.bodyMedium,
        )
        LazyRow(content = {
            items(12) {
                TitleItemVariant(
                    title = "Artist Name",
                )
            }
        })
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = "Title",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = "Subheading about this section",
            style = MaterialTheme.typography.bodyMedium,
        )
        LazyRow(content = {
            items(12) {
                TitleItemVariantVariant(
                    title = "Playlist ${it + 1}",
                )
            }
        })
    }
}

@Composable
fun TitleItem(title: String, description: String) {
    Column(
        modifier = Modifier.padding(
            end = 16.dp,
            top = 8.dp,
            bottom = 8.dp
        )
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .size(144.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
        ){
            AsyncImage(
                model = "https://picsum.photos/200/300",
                modifier = Modifier.fillMaxSize(),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
        )
    }

}

@Composable
fun TitleItemVariant(title: String) {
    Column(
        modifier = Modifier.padding(
            end = 16.dp,
            top = 8.dp,
            bottom = 8.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(120.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
        ){
            AsyncImage(
                model = "https://picsum.photos/200/300",
                modifier = Modifier.fillMaxSize(),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.size(6.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Composable
fun TitleItemVariantVariant(title: String) {
    Column(
        modifier = Modifier.padding(
            end = 16.dp,
            top = 8.dp,
            bottom = 8.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .size(144.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
        ){
            AsyncImage(
                model = "https://picsum.photos/200/300",
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}