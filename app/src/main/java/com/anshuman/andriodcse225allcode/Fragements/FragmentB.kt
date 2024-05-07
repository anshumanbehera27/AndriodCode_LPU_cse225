package com.anshuman.andriodcse225allcode.Fragements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.anshuman.andriodcse225allcode.R


class FragmentB : Fragment() {
    private lateinit var textViewReceivedData:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_b, container, false)
        textViewReceivedData = rootView.findViewById(R.id.textViewReceivedData)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val receivedData = arguments?.getString("data")
        val reciveData2 = arguments?.getString("data1")
        if (!receivedData.isNullOrEmpty()) {
            textViewReceivedData.text = "Received Data: $receivedData  and $reciveData2"
            textViewReceivedData.visibility = View.VISIBLE
        }
    }


}