package com.igorwojda.showcase.base.presentation.navigation

sealed class NavigationFlow {
    object ClientFlow : NavigationFlow()
    object DocumentFlow : NavigationFlow()

    object ServiceFlow : NavigationFlow()
    object ServiceHailFlow : NavigationFlow()
    object ServicePartFlow : NavigationFlow()
    object ServicePdrFlow : NavigationFlow()
    object ServiceRrriFlow : NavigationFlow()
}
