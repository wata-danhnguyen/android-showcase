package com.igorwojda.showcase.feature.client.presentation.client

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.igorwojda.showcase.base.delegate.viewBinding
import com.igorwojda.showcase.base.presentation.fragment.InjectionFragment
import com.igorwojda.showcase.base.presentation.navigation.DeepLinkDestination
import com.igorwojda.showcase.base.presentation.navigation.deepLinkNavigateTo
import com.igorwojda.showcase.feature.client.R
import com.igorwojda.showcase.feature.client.databinding.FragmentClientBinding

class ClientFragment : InjectionFragment(R.layout.fragment_client) {

    private val binding: FragmentClientBinding by viewBinding()

    override fun onResume() {
        super.onResume()
        binding.underConstructionAnimation.playAnimation()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.underConstructionAnimation.setOnClickListener {
            findNavController().deepLinkNavigateTo(DeepLinkDestination.Client)
        }
    }
}
