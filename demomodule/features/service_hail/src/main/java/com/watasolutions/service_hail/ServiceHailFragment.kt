package com.watasolutions.service_hail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.watasolutions.service_hail.databinding.FragmentServiceHailBinding

class ServiceHailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentServiceHailBinding.inflate(inflater, container, false)
        return binding.root
    }
}