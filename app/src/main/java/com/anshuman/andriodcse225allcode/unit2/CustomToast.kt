package com.anshuman.andriodcse225allcode.unit2

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import com.anshuman.andriodcse225allcode.R


class CustomToast {
    companion object {
        fun showToast(context: Context, message: String) {
            val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val layout = layoutInflater.inflate(R.layout.coustom_toast_layout, null)
            val textview = layout.findViewById<TextView>(R.id.text)
            textview.text = message

            val toast = Toast(context)
            toast.duration = Toast.LENGTH_SHORT
            toast.view = layout
            toast.show()
        }
    }

}