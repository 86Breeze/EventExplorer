package com.example.eventexplorer8909157.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.eventexplorer8909157.data.Event
import com.example.eventexplorer8909157.ui.screens.LocalContextImageId

@Composable
fun EventCard(event: Event, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 12.dp)
    ) {
        Card(
            onClick = onClick,
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(modifier = Modifier.padding(12.dp)) {
                val imageId = LocalContextImageId(event.imageResName)
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = event.title,
                    modifier = Modifier
                        .size(80.dp)
                        .padding(end = 12.dp)
                )
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp)) {
                    Text(text = event.title, style = MaterialTheme.typography.titleMedium)
                    Text(text = event.category.name, style = MaterialTheme.typography.bodySmall)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = "${event.date} • ${event.time}", style = MaterialTheme.typography.bodySmall)
                    Text(text = event.location, style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}