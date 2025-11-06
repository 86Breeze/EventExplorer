package com.example.eventexplorer8909157.data

import java.util.*

// enum class defining event category types
enum class Category { Music, Sports, Workshop, Exhibition }

data class Event(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val category: Category,
    val date: String,
    val time: String,
    val location: String,
    val description: String,
    val ticketPrice: String,
    val imageResName: String // drawable resource name
)
