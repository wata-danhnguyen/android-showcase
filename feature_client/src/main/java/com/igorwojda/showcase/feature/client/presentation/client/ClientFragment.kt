package com.igorwojda.showcase.feature.client.presentation.client

import com.igorwojda.showcase.base.delegate.viewBinding
import com.igorwojda.showcase.base.presentation.fragment.InjectionFragment
import com.igorwojda.showcase.feature.client.R
import com.igorwojda.showcase.feature.client.databinding.FragmentClientBinding

class ClientFragment : InjectionFragment(R.layout.fragment_client) {

    private val binding: FragmentClientBinding by viewBinding()

    override fun onResume() {
        super.onResume()
        binding.underConstructionAnimation.playAnimation()
    }
}
