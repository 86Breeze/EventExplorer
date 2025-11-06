package com.example.eventexplorer8909157.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.eventexplorer8909157.data.Category
import com.example.eventexplorer8909157.ui.screens.components.EventCard
import com.example.eventexplorer8909157.viewmodel.EventViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventListScreen(
    viewModel: EventViewModel,
    onEventClick: (String) -> Unit
) {
    //retrieving state values from viewmodel
    val selectedLocation = viewModel.selectedLocation
    val locations = viewModel.locations
    val events = viewModel.filteredEvents
    val selectedCategories = viewModel.selectedCategories

    var expanded by remember { mutableStateOf(false) }
    var dropdownText by remember { mutableStateOf(selectedLocation) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Event Explorer") }
            )
        }
    ) { padding ->
        // user can scroll through the list
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()) // 👈 enables scrolling
                .padding(horizontal = 12.dp)
        ) {
            // dropdown for location
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                TextField(
                    readOnly = true,
                    value = dropdownText,
                    onValueChange = {},
                    label = { Text("Select Location") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    locations.forEach { loc ->
                        DropdownMenuItem(
                            text = { Text(text = loc) },
                            onClick = {
                                dropdownText = loc
                                viewModel.setLocation(loc)
                                expanded = false
                            }
                        )
                    }
                }
            }
            // filter chips
            Text(
                text = "Filter by Category:",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
            )
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(listOf(Category.Music, Category.Sports, Category.Workshop, Category.Exhibition).size) { index ->
                    val category = listOf(Category.Music, Category.Sports, Category.Workshop, Category.Exhibition)[index]
                    FilterChip(
                        selected = selectedCategories.contains(category),
                        onClick = { viewModel.toggleCategory(category) },
                        label = { Text(text = category.name) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            //event list sectionn
            events.forEach { e ->
                EventCard(event = e, onClick = { onEventClick(e.id) })
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}
