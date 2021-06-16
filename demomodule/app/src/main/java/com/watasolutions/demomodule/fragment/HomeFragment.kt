package com.watasolutions.demomodule.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.watasolutions.demomodule.adapter.EstimateAdapter
import com.watasolutions.demomodule.databinding.FragmentHomeBinding
import com.watasolutions.demomodule.model.Estimate
import com.watasolutions.demomodule.navigation.NavigationFlow
import com.watasolutions.demomodule.navigation.ToFlowNavigatable
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val estimateAdapter: EstimateAdapter by lazy {
        EstimateAdapter(requireContext(), mutableListOf())
    }

    var isFirst = true
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        println("### onCreateView: HomeFragment")
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println("### onViewCreated: HomeFragment")
        btnNewEstimate.setOnClickListener {
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.EstimateFlow)
        }

        btnToScheduling.setOnClickListener {
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.SchedulingFlow)
        }

        rcvEstimate.adapter = estimateAdapter

//        if (isFirst) {
        estimateAdapter.updateData(create1000Estimate())
        isFirst = false

//        }
    }

    override fun onPause() {
        super.onPause()
        println("### onPause: HomeFragment")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("### onDestroy: HomeFragment")
    }

    override fun onStop() {
        super.onStop()
        println("### onStop: HomeFragment")
    }

    private fun create1000Estimate(): List<Estimate> {
        val list = mutableListOf<Estimate>()
        repeat(1000) {
            list.add(
                Estimate(
                    id = it,
                    name = "name $it $isFirst",
                    vehicle = "2018 Buick Envision, Black +1 more",
                    date = "06/16/2021"
                )
            )
        }
        return list
    }
}