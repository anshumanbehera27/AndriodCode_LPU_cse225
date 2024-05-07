package com.anshuman.andriodcse225allcode.Fragements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.anshuman.andriodcse225allcode.R


class FragementA : Fragment() {
    lateinit var btnSendData:Button
    private lateinit var editTextData: EditText
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_fragement_a, container, false)
        btnSendData = rootView.findViewById(R.id.btnSendData)
        editTextData = rootView.findViewById(R.id.editTextData)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSendData.setOnClickListener {
            val dataToSend = editTextData.text.toString().trim()
            if (dataToSend.isNotEmpty()) {
                val bundle = Bundle()
                bundle.putString("data", dataToSend)

                val fragmentB = FragmentB()
                fragmentB.arguments = bundle

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragmentB)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }


}