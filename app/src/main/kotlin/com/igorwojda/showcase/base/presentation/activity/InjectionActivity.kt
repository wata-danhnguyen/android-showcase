package com.igorwojda.showcase.base.presentation.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.igorwojda.showcase.BuildConfig
import org.kodein.di.Copy
import org.kodein.di.DIAware
import org.kodein.di.DITrigger
import org.kodein.di.android.retainedSubDI
import org.kodein.di.diContext

abstract class InjectionActivity : AppCompatActivity(), DIAware {

    @SuppressWarnings("LeakingThisInConstructor")
    final override val diContext = diContext<AppCompatActivity>(this)

    // Using retainedKodein will not recreate Kodein when the Activity restarts
    override val di by retainedSubDI(di(), copy = Copy.All) { }

    /*
    Dependency resolution for debug builds:
    By defining kodeinTrigger we can eagerly retrieve all dependencies in onCreate method. This allow us to be sure
    that all dependencies have correctly been retrieved (there were no non-declared dependencies and no dependency
    loops)

    Dependency resolution for release builds:
    By not using kodeinTrigger all dependencies will be resolved lazily. This allow to save some resources and speed up
    the application by retrieving dependencies only when they are needed/used.

    More:
    https://github.com/Kodein-Framework/Kodein-DI/blob/master/doc/android.adoc#using-a-trigger
    http://kodein.org/Kodein-DI/?latest/android#_using_a_trigger

     */
    final override val diTrigger: DITrigger? by lazy {
        if (BuildConfig.DEBUG) DITrigger() else super.diTrigger
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        diTrigger?.trigger()
    }
}
