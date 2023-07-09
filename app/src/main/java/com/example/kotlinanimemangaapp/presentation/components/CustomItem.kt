package com.example.kotlinanimemangaapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinanimemangaapp.domain.model.Manga

@Composable
fun CustomItem(
    manga: Manga,
    onItemClick: (Manga) -> Unit
) {
    Row(
        modifier = Modifier
            .background(Color.LightGray, MaterialTheme.shapes.medium)
            .fillMaxWidth()
            .clickable { onItemClick(manga) }
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "${manga.popularity}",
            color = Color.Black,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = manga.title,
            color = Color.Black,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Normal
        )
    }
}


@Composable
@Preview
fun CustomItemPreview() {
    CustomItem(
        manga = Manga(
            id = 1,
            title = "Naruto",
            popularity = 1,
            image_url = "https://cdn.myanimelist.net/images/manga/2/199950.jpg?s=8f7a4b7d4d4b2b4b4b4b4b4b4b4b4b4b"
        ),
        onItemClick = {}
    )
}