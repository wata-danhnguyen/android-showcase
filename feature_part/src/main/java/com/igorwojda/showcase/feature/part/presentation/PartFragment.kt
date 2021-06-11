package com.igorwojda.showcase.feature.part.presentation

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.igorwojda.showcase.base.delegate.viewBinding
import com.igorwojda.showcase.base.presentation.fragment.InjectionFragment
import com.igorwojda.showcase.feature.part.R
import com.igorwojda.showcase.feature.part.databinding.FragmentPartBinding

class PartFragment : InjectionFragment(R.layout.fragment_part) {

    private val binding: FragmentPartBinding by viewBinding()

    override fun onResume() {
        super.onResume()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCompleteServicePart.setOnClickListener {
            setFragmentResult("service_key", bundleOf("part_data" to "Hail data"))

            findNavController().navigateUp()
        }
    }
}
