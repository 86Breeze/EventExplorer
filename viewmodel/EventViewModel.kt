package com.example.eventexplorer8909157.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.eventexplorer8909157.data.Category
import com.example.eventexplorer8909157.data.Event
import com.example.eventexplorer8909157.repository.EventRepository

class EventViewModel : ViewModel() {
    private val repository = EventRepository()
    private val allEvents = repository.getAllEvents()

    // variable holding location in drowpdown menu
    var selectedLocation by mutableStateOf("All")
        private set

    // varible holding selected categories filters
    var selectedCategories by mutableStateOf(setOf<Category>())
        private set

    // selected event id will be set when navigating to detail
    var selectedEventId by mutableStateOf<String?>(null)
        private set

    val locations = repository.getLocations()

    // displaying events as per the filters
    val filteredEvents: List<Event>
        get() {
            val byLocation = if (selectedLocation == "All") allEvents
            else allEvents.filter { it.location == selectedLocation }

            val byCategory = if (selectedCategories.isEmpty()) byLocation
            else byLocation.filter { selectedCategories.contains(it.category) }

            return byCategory
        }
    fun setLocation(location: String) {
        selectedLocation = location
    }
    fun toggleCategory(category: Category) {
        selectedCategories = if (selectedCategories.contains(category)) {
            selectedCategories - category
        } else {
            selectedCategories + category
        }
    }
    fun selectEvent(id: String) {
        selectedEventId = id
    }
    fun getSelectedEvent(): Event? {
        val id = selectedEventId ?: return null
        return allEvents.find { it.id == id }
    }
}
