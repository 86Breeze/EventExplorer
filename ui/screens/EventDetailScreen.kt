@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.eventexplorer8909157.ui.screens

import android.R.attr.name
import android.content.Context
import com.example.eventexplorer8909157.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Alignment
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.text.font.FontWeight
import com.example.eventexplorer8909157.viewmodel.EventViewModel

// displaying single event details selected from list
@Composable
fun EventDetailScreen(viewModel: EventViewModel, onBack: () -> Unit) {
    val event = viewModel.getSelectedEvent()

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = event?.title ?: "") },
            navigationIcon = {
                IconButton(onClick = { onBack() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            })
    }) { padding ->
        event?.let { e ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(12.dp)
                    .fillMaxSize()
            ) {
                // card displays event image and information
                Card(
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        val imageId = LocalContextImageId(e.imageResName)
                        Image(
                            painter = painterResource(id = imageId),
                            contentDescription = e.title,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                        )
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(text = e.title, style = MaterialTheme.typography.titleLarge)
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(text = e.category.name, style = MaterialTheme.typography.bodySmall)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "${e.date} • ${e.time}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(text = e.location, style = MaterialTheme.typography.bodyMedium)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = e.description, style = MaterialTheme.typography.bodyMedium)
                            Spacer(modifier = Modifier.height(14.dp))
                            Text(
                                text = "Tickets",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                            )
                            Text(text = e.ticketPrice, style = MaterialTheme.typography.titleMedium)
                            Spacer(modifier = Modifier.height(12.dp))
                            Button(
                                onClick = { /* No functionality required */ },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(text = "Buy Tickets")
                            }
                        }
                    }
                }
            }
        } ?: run {
            // if no event selected, a placeholder image would be displayed
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "No event selected")
            }
        }
    }
}

// this converts string name into drawable resource ID
@Composable
fun LocalContextImageId(name: String): Int {
    val context = LocalContext.current
    val id = context.resources.getIdentifier(name, "drawable", context.packageName)
    return if (id != 0) id else R.drawable.placeholder
}