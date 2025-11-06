# 🎟️ Event Explorer App

**EventExplorer8909157** is an Android application built with **Kotlin** and **Jetpack Compose** that allows users to explore upcoming local events such as concerts, sports tournaments, workshops, and exhibitions.  
Users can filter events by **location** and **category**, and view detailed information for each event.

---

## 🧠 Project Overview

This project demonstrates:
- Use of **Jetpack Compose UI components** such as `Card`, `Surface`, `LazyColumn`, `LazyRow`, `FilterChip`, and `ExposedDropdownMenuBox`.
- Implementation of **state management** with `ViewModel` and `mutableStateOf`.
- Use of **Jetpack Navigation** for screen transitions.
- **Material 3 Theming** for consistent light/dark mode UI.
- Proper **project structure**, code commenting, and adherence to **Android development best practices**.

---

## 🖥️ Features

### 🗂️ Event List Screen
- Displays a list of all events categorized under Music, Sports, Workshop, and Exhibition.
- Allows filtering:
  - By **Location** using an `ExposedDropdownMenuBox` (Toronto, Vancouver, Montreal).
  - By **Category** using `FilterChip`.
- Each event is displayed inside a `Card` within a `Surface` for elevation and visual separation.
- Clicking an event navigates to the **Event Detail Screen**.

### 📄 Event Detail Screen
- Shows complete event information:
  - Title, Category, Image, Date, Time, Location, Description, and Ticket Price.
- Includes a “Buy Tickets” button (non-functional as per project scope).
- Provides a back navigation button to return to the event list.

---

## 🧩 Tech Stack

| Component | Description |
|------------|-------------|
| **Language** | Kotlin |
| **UI Framework** | Jetpack Compose |
| **Architecture** | MVVM (Model-View-ViewModel) |
| **State Management** | ViewModel + Compose State |
| **Navigation** | Jetpack Navigation Compose |
| **Design System** | Material Design 3 (Material You) |
| **Min SDK** | 21 |
| **Compile SDK** | 36 |

---

## 📂 Project Structure
app/
├── src/main/
│ ├── java/com/example/eventexplorer8909157/
│ │ ├── data/ # Data models and sample data
│ │ ├── repository/ # Event repository
│ │ ├── viewmodel/ # EventViewModel for state handling
│ │ ├── navigation/ # AppNavHost and route management
│ │ ├── ui/
│ │ │ ├── screens/ # Compose screens (EventListScreen, EventDetailScreen)
│ │ │ └── components/# Reusable UI components (EventCard)
│ └── res/
│ ├── drawable/ # Event images (concert1, concert2, etc.)
│ ├── values/ # Themes, colors, strings
│ └── AndroidManifest.xml
