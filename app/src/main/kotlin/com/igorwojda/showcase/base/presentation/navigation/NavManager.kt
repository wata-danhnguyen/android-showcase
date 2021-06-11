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
    }

    fun navigate(navDirections: NavDirections) {
        navEventListener?.invoke(navDirections)
    }

    fun setOnNavEvent(navEventListener: (navDirections: NavDirections) -> Unit) {
        this.navEventListener = navEventListener
    }
}
