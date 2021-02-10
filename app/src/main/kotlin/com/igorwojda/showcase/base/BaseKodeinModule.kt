package com.igorwojda.showcase.base

import com.igorwojda.showcase.base.presentation.navigation.NavManager
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

internal const val MODULE_NAME = "Base"

val baseModule = DI.Module("${MODULE_NAME}Module") {

    bind() from singleton { NavManager() }
}
