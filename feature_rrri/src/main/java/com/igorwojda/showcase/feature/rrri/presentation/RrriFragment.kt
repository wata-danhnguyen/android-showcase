package com.igorwojda.showcase.feature.rrri.presentation

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.igorwojda.showcase.base.delegate.viewBinding
import com.igorwojda.showcase.base.presentation.fragment.InjectionFragment
import com.igorwojda.showcase.feature.rrri.R
import com.igorwojda.showcase.feature.rrri.databinding.FragmentRrriBinding

class RrriFragment : InjectionFragment(R.layout.fragment_rrri) {

    private val binding: FragmentRrriBinding by viewBinding()

    override fun onResume() {
        super.onResume()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCompleteServiceRrri.setOnClickListener {
            setFragmentResult("service_key", bundleOf("rrri_data" to "Rrri data"))

            findNavController().navigateUp()
        }
    }
}
