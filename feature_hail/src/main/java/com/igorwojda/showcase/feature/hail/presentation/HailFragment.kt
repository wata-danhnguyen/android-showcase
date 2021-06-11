package com.igorwojda.showcase.feature.hail.presentation

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.igorwojda.showcase.base.delegate.viewBinding
import com.igorwojda.showcase.base.presentation.fragment.InjectionFragment
import com.igorwojda.showcase.feature.hail.R
import com.igorwojda.showcase.feature.hail.databinding.FragmentHailBinding

class HailFragment : InjectionFragment(R.layout.fragment_hail) {

    private val binding: FragmentHailBinding by viewBinding()

    override fun onResume() {
        super.onResume()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCompleteServiceHail.setOnClickListener {
            setFragmentResult("service_key", bundleOf("hail_data" to "Hail data"))

            findNavController().navigateUp()
        }
    }
}
