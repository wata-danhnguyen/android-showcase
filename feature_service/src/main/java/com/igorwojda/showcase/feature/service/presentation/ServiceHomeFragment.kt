package com.igorwojda.showcase.feature.service.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.setFragmentResultListener
import com.igorwojda.showcase.base.delegate.viewBinding
import com.igorwojda.showcase.base.presentation.fragment.InjectionFragment
import com.igorwojda.showcase.base.presentation.navigation.NavManager
import com.igorwojda.showcase.base.presentation.navigation.NavigationFlow
import com.igorwojda.showcase.base.presentation.navigation.ToFlowNavigatable
import com.igorwojda.showcase.feature.service.R
import com.igorwojda.showcase.feature.service.databinding.FragmentServiceHomeBinding
import org.kodein.di.generic.instance

class ServiceHomeFragment : InjectionFragment(R.layout.fragment_service_home) {

    private val binding: FragmentServiceHomeBinding by viewBinding()

    private val navManager: NavManager by instance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("service_key") { key, bundle ->
            println("##### ${key}")
            bundle.getString("hail_data")?.let {
                binding.tvServiceHailData.text = it
            }

            bundle.getString("part_data")?.let {
                binding.tvServicePartData.text = it
            }

            bundle.getString("pdr_data")?.let {
                binding.tvServicepdrData.text = it
            }

            bundle.getString("rrri_data")?.let {
                binding.tvServiceRrriData.text = it
            }
        }

        binding.btnServiceHail.setOnClickListener {
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.ServiceHailFlow)
        }

        binding.btnServicePart.setOnClickListener {
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.ServicePartFlow)
        }

        binding.btnServicePdr.setOnClickListener {
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.ServicePdrFlow)
        }

        binding.btnServiceRrri.setOnClickListener {
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.ServiceRrriFlow)
        }
    }
}
