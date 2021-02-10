package com.igorwojda.showcase.app.feature

import org.kodein.di.DI

interface KodeinModuleProvider {

    val kodeinModule: DI.Module
}
