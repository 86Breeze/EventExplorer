package com.example.eventexplorer8909157.data

object SampleData {

    // available locations would shows as dropdown menu
    val locations = listOf("All", "Toronto", "Vancouver", "Montreal")

    val events = listOf(
        // Music events
        Event(
            title = "Jazz Concert",
            category = Category.Music,
            date = "Oct 20, 2025",
            time = "7:00 PM",
            location = "Toronto",
            description = "A relaxing evening of smooth jazz.",
            ticketPrice = "$50",
            imageResName = "concert1"
        ),
        Event(
            title = "Indie Night",
            category = Category.Music,
            date = "Nov 03, 2025",
            time = "8:00 PM",
            location = "Vancouver",
            description = "Live indie bands performing.",
            ticketPrice = "$25",
            imageResName = "concert2"
        ),

        // Sports events
        Event(
            title = "City Marathon",
            category = Category.Sports,
            date = "Nov 5, 2025",
            time = "9:00 AM",
            location = "Vancouver",
            description = "Run through the city — all levels welcome.",
            ticketPrice = "$30",
            imageResName = "sports1"
        ),
        Event(
            title = "Soccer Cup",
            category = Category.Sports,
            date = "Dec 1, 2025",
            time = "2:00 PM",
            location = "Toronto",
            description = "Local teams compete for the trophy.",
            ticketPrice = "$15",
            imageResName = "sports2"
        ),

        // Workshops
        Event(
            title = "Photography Workshop",
            category = Category.Workshop,
            date = "Nov 12, 2025",
            time = "11:00 AM",
            location = "Montreal",
            description = "Hands-on photography training for beginners.",
            ticketPrice = "$75",
            imageResName = "workshop1"
        ),
        Event(
            title = "Coding Bootcamp",
            category = Category.Workshop,
            date = "Dec 02, 2025",
            time = "9:00 AM",
            location = "Vancouver",
            description = "Intro to coding and software development.",
            ticketPrice = "$100",
            imageResName = "workshop2"
        ),

        // Exhibition events
        Event(
            title = "Art Exhibition",
            category = Category.Exhibition,
            date = "Dec 1, 2025",
            time = "4:00 PM",
            location = "Toronto",
            description = "Local artists showcase creative work.",
            ticketPrice = "$12",
            imageResName = "exhibition1"
        ),
        Event(
            title = "Design Showcase",
            category = Category.Exhibition,
            date = "Dec 09, 2025",
            time = "6:00 PM",
            location = "Vancouver",
            description = "Designers present their latest innovations.",
            ticketPrice = "$15",
            imageResName = "exhibition2"
        )
    )
}
