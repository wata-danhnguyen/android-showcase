package com.igorwojda.showcase.feature.onboarding

import com.igorwojda.showcase.app.feature.KodeinModuleProvider
import org.kodein.di.Kodein

internal const val MODULE_NAME = "Onboaring"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
//        import(presentationModule)
//        import(domainModule)
//        import(dataModule)
    }
}
