package com.example.eventexplorer8909157.repository

import com.example.eventexplorer8909157.data.Event
import com.example.eventexplorer8909157.data.SampleData

// repository class provides event data to the viewmodel
class EventRepository {
    fun getAllEvents(): List<Event> = SampleData.events
    fun getLocations(): List<String> = SampleData.locations
    fun getEventById(id: String): Event? = SampleData.events.find { it.id == id }
}
