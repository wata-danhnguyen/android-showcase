package com.igorwojda.showcase.base.presentation.navigation

import android.net.Uri
import androidx.navigation.NavController
import androidx.navigation.NavDirections

class NavManager {
    private var navEventListener: ((navDirections: NavDirections) -> Unit)? = null

    private var navDeeplinkEventListener: ((deepLink: Uri) -> Unit)? = null

    var navController : NavController? = null

    fun navigate(id: Int) {
        navController?.navigate(id)
    }

    fun navigate(navDirections: NavDirections) {
        navEventListener?.invoke(navDirections)
    }

    fun navigate(deepLink: Uri) {
        navDeeplinkEventListener?.invoke(deepLink)
    }

    fun setOnNavEvent(navEventListener: (navDirections: NavDirections) -> Unit) {
        this.navEventListener = navEventListener
    }

    fun setOnNavDeepLinkEvent(navEventListener: (deepLink: Uri) -> Unit) {
        this.navDeeplinkEventListener = navEventListener
    }
}
