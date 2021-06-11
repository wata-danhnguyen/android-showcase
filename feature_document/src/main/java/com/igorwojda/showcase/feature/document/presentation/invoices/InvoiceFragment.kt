package com.igorwojda.showcase.feature.document.presentation.invoices

import com.igorwojda.showcase.base.delegate.viewBinding
import com.igorwojda.showcase.base.presentation.fragment.InjectionFragment
import com.igorwojda.showcase.feature.document.R
import com.igorwojda.showcase.feature.document.databinding.FragmentInvoiceBinding

class InvoiceFragment : InjectionFragment(R.layout.fragment_invoice) {

    private val binding: FragmentInvoiceBinding by viewBinding()

    override fun onResume() {
        super.onResume()
        binding.underConstructionAnimation.playAnimation()
    }
}
