package com.igorwojda.showcase.base.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.igorwojda.showcase.AppNavGraphDirections

class NavManager {
    private var navEventListener: ((navDirections: NavDirections) -> Unit)? = null

    lateinit var navController: NavController

    fun navigateToFlow(navigationFlow: NavigationFlow) = when (navigationFlow) {
        NavigationFlow.ClientFlow -> navController.navigate(AppNavGraphDirections.actionGlobalClientFlow())
        NavigationFlow.DocumentFlow -> navController.navigate(AppNavGraphDirections.actionGlobalDocumentFlow())
        NavigationFlow.ServiceFlow -> navController.navigate(AppNavGraphDirections.actionGlobalServiceFlow())

        NavigationFlow.ServiceHailFlow -> navController.navigate(AppNavGraphDirections.actionGlobalHailFlow())
        NavigationFlow.ServicePartFlow -> navController.navigate(AppNavGraphDirections.actionGlobalPartFlow())
        NavigationFlow.ServicePdrFlow -> navController.navigate(AppNavGraphDirections.actionGlobalPdrFlow())
        NavigationFlow.ServiceRrriFlow -> navController.navigate(AppNavGraphDirections.actionGlobalRrriFlow())
    }

    fun navigate(navDirections: NavDirections) {
        navEventListener?.invoke(navDirections)
    }

    fun setOnNavEvent(navEventListener: (navDirections: NavDirections) -> Unit) {
        this.navEventListener = navEventListener
    }
}
