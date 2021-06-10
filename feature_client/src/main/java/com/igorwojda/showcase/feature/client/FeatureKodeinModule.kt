package com.igorwojda.showcase.feature.client

import com.igorwojda.showcase.app.feature.KodeinModuleProvider
import com.igorwojda.showcase.feature.client.data.dataModule
import com.igorwojda.showcase.feature.client.domain.domainModule
import com.igorwojda.showcase.feature.client.presentation.presentationModule
import org.kodein.di.Kodein

internal const val MODULE_NAME = "Client"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
        import(presentationModule)
        import(domainModule)
        import(dataModule)
    }
}
