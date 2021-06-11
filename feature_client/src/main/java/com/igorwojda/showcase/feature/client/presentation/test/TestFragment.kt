package com.igorwojda.showcase.feature.client.presentation.test

import com.igorwojda.showcase.base.delegate.viewBinding
import com.igorwojda.showcase.base.presentation.fragment.InjectionFragment
import com.igorwojda.showcase.feature.client.R
import com.igorwojda.showcase.feature.client.databinding.FragmentClientBinding

class TestFragment : InjectionFragment(R.layout.fragment_test) {

    private val binding: FragmentClientBinding by viewBinding()

    override fun onResume() {
        super.onResume()
        binding.underConstructionAnimation.playAnimation()
    }
}
