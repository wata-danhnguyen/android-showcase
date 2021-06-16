package com.watasolutions.demomodule.fragment

import androidx.lifecycle.ViewModel
import com.watasolutions.demomodule.model.Estimate

class HomeViewModel : ViewModel() {

//    val list = Mutable

    private fun create1000Estimate(): List<Estimate> {
        val list = mutableListOf<Estimate>()
        repeat(1000) {
            list.add(
                Estimate(
                    id = it,
                    name = "name $it",
                    vehicle = "2018 Buick Envision, Black +1 more",
                    date = "06/16/2021"
                )
            )
        }
        return list
    }
}