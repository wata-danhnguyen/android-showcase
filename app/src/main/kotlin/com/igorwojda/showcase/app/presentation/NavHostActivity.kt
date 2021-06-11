package com.igorwojda.showcase.app.presentation

import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import com.igorwojda.showcase.R
import com.igorwojda.showcase.base.delegate.viewBinding
import com.igorwojda.showcase.base.extension.navigateSafe
import com.igorwojda.showcase.base.presentation.activity.BaseActivity
import com.igorwojda.showcase.base.presentation.navigation.NavManager
import com.igorwojda.showcase.base.presentation.navigation.NavigationFlow
import com.igorwojda.showcase.base.presentation.navigation.ToFlowNavigatable
import com.igorwojda.showcase.databinding.ActivityNavHostBinding
import org.kodein.di.generic.instance

class NavHostActivity : BaseActivity(), ToFlowNavigatable {

    private val binding: ActivityNavHostBinding by viewBinding()

    private val navController get() = findNavController(this, R.id.navHostFragment)

    private val navManager: NavManager by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        navManager.navController = navController
        initNavManager()
    }

    private fun initNavManager() {
        navManager.setOnNavEvent {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment)
            val currentFragment = navHostFragment?.childFragmentManager?.fragments?.get(0)

            currentFragment?.navigateSafe(it)
        }
    }

    override fun navigateToFlow(flow: NavigationFlow) {
        navManager.navigateToFlow(flow)
    }
}
