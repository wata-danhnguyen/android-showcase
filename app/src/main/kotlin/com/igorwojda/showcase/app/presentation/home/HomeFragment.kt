package com.igorwojda.showcase.app.presentation.home

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.igorwojda.showcase.R
import com.igorwojda.showcase.base.delegate.viewBinding
import com.igorwojda.showcase.base.presentation.fragment.InjectionFragment
import com.igorwojda.showcase.base.presentation.navigation.*
import com.igorwojda.showcase.databinding.FragmentHomeBinding
import org.kodein.di.generic.instance

class HomeFragment : InjectionFragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBinding()

    private val navManager: NavManager by instance()

    override fun onResume() {
        super.onResume()
        binding.underConstructionAnimation.playAnimation()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnToClient.setOnClickListener {
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.ClientFlow)
        }

        binding.btnToTest.setOnClickListener {
            findNavController().deepLinkNavigateTo(DeepLinkDestination.Test)
        }

        binding.btnToDocument.setOnClickListener {
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.DocumentFlow)
        }
    }
}
