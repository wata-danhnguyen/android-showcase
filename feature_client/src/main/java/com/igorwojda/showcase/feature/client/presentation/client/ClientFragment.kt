package com.igorwojda.showcase.feature.client.presentation.client

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
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

        binding.btnPickclient.setOnClickListener {
            setFragmentResult("client_id_pick", bundleOf("client_id_name" to "client id 123"))

            // Step 4. Go back to Fragment A
            findNavController().navigateUp()
        }
    }
}
