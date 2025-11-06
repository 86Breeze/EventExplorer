package com.example.eventexplorer8909157.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.eventexplorer8909157.ui.screens.EventDetailScreen
import com.example.eventexplorer8909157.ui.screens.EventListScreen
import com.example.eventexplorer8909157.viewmodel.EventViewModel

// object holding route names to use for navigation
object Routes {
    const val LIST = "event_list"
    const val DETAIL = "event_detail"
}

// main navigation host function
@Composable
fun AppNavHost(navController: NavHostController, viewModel: EventViewModel = viewModel()) {
    NavHost(navController = navController, startDestination = Routes.LIST) {
        composable(Routes.LIST) {
            EventListScreen(
                viewModel = viewModel,
                onEventClick = { eventId ->
                    viewModel.selectEvent(eventId)
                    navController.navigate(Routes.DETAIL)
                }
            )
        }
        composable(Routes.DETAIL) {
            EventDetailScreen(viewModel = viewModel,
                onBack = { navController.popBackStack() })
        }
    }
}
