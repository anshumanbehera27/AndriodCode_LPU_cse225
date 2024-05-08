package com.anshuman.andriodcse225allcode.Traffic_light

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anshuman.andriodcse225allcode.R


class TrafficLightFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_traffic_light, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // You can initialize your views and set up any listeners here
        val trafficLightView = view.findViewById<TrafficLightView>(R.id.traffic_light_view)

        // Set initial traffic light color
        trafficLightView.setLightColor(Color.RED)
    }


}