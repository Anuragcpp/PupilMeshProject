package com.example.pupilmeshporject.presentation.MainScreen.MangaPage

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage

@Composable
fun ManagaScreen(
    viewModel: MangaViewModel = hiltViewModel()
) {

    val mangaItems = viewModel.mangaPagingFlow.collectAsLazyPagingItems()

    LazyColumn {
        items(mangaItems.itemCount) { index ->

                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        //TODO when api get the image url then uncomment this
//                        AsyncImage(
//                            model = mangaItems[index]?.imageURL,
//                            contentDescription = mangaItems[index]?.title,
//                            modifier = Modifier.size(80.dp)
//                        )
                        Spacer(modifier = Modifier.width(10.dp))

                        Text(text = mangaItems[index]?.title.toString(), fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    
}