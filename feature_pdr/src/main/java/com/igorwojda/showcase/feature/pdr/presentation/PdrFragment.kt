package com.igorwojda.showcase.feature.pdr.presentation

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.igorwojda.showcase.base.delegate.viewBinding
import com.igorwojda.showcase.base.presentation.fragment.InjectionFragment
import com.igorwojda.showcase.feature.pdr.R
import com.igorwojda.showcase.feature.pdr.databinding.FragmentPdrBinding

class PdrFragment : InjectionFragment(R.layout.fragment_pdr) {

    private val binding: FragmentPdrBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCompleteServicePdr.setOnClickListener {
            setFragmentResult("service_key", bundleOf("pdr_data" to "Pdr data"))

            findNavController().navigateUp()
        }
    }
}
