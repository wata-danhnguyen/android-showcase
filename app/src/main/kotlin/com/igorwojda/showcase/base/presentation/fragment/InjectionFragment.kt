package com.igorwojda.showcase.base.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.igorwojda.showcase.BuildConfig
import org.kodein.di.DIAware
import org.kodein.di.DITrigger
import org.kodein.di.diContext

/*
See description in InjectionActivity class
 */


// Compilation Error: https://youtrack.jetbrains.com/issue/KT-44843
abstract class InjectionFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId), DIAware {

    @SuppressWarnings("LeakingThisInConstructor")
    final override val diContext = diContext<Fragment>(this)

    final override val di by di()

    final override val diTrigger: DITrigger? by lazy {
        if (BuildConfig.DEBUG) DITrigger() else super.diTrigger
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        diTrigger?.trigger()
    }
}
