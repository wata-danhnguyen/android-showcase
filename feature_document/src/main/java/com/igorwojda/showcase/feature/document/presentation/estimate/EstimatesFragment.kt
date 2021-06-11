package com.igorwojda.showcase.feature.document.presentation.estimate

import android.os.Bundle
import android.view.View
import androidx.fragment.app.setFragmentResultListener
import com.igorwojda.showcase.base.delegate.viewBinding
import com.igorwojda.showcase.base.presentation.fragment.InjectionFragment
import com.igorwojda.showcase.base.presentation.navigation.NavManager
import com.igorwojda.showcase.base.presentation.navigation.NavigationFlow
import com.igorwojda.showcase.base.presentation.navigation.ToFlowNavigatable
import com.igorwojda.showcase.feature.document.R
import com.igorwojda.showcase.feature.document.databinding.FragmentEstimateBinding
import org.kodein.di.generic.instance

class EstimatesFragment : InjectionFragment(R.layout.fragment_estimate) {

    private val binding: FragmentEstimateBinding by viewBinding()

    private val navManager: NavManager by instance()

    override fun onResume() {
        super.onResume()
        binding.underConstructionAnimation.playAnimation()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("client_id_pick") { key, bundle ->
            binding.edtClientName.setText(bundle.getString("client_id_name") ?: "Ko nhận dc")
        }

        binding.btnToClient.setOnClickListener {
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.ClientFlow)
        }
    }
}
