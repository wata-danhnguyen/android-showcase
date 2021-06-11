package com.igorwojda.showcase.feature.document.presentation.document

import android.os.Bundle
import android.view.View
import com.igorwojda.showcase.base.delegate.viewBinding
import com.igorwojda.showcase.base.presentation.fragment.InjectionFragment
import com.igorwojda.showcase.base.presentation.navigation.NavManager
import com.igorwojda.showcase.feature.document.R
import com.igorwojda.showcase.feature.document.databinding.FragmentDocumentBinding
import org.kodein.di.generic.instance

class DocumentFragment : InjectionFragment(R.layout.fragment_document) {

    private val binding: FragmentDocumentBinding by viewBinding()

    private val navManager: NavManager by instance()

    override fun onResume() {
        super.onResume()
        binding.underConstructionAnimation.playAnimation()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnToEstimateFragment.setOnClickListener {
            val navDirections = DocumentFragmentDirections.actionDocumentFragmentToEstimatesFragment()
            navManager.navigate(navDirections)
        }

        binding.btnToInvoiceFragment.setOnClickListener {
            val navDirections = DocumentFragmentDirections.actionDocumentFragmentToInvoiceFragment()
            navManager.navigate(navDirections)
        }
    }
}
