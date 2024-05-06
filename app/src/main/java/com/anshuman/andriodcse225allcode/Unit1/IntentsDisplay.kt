package com.anshuman.andriodcse225allcode.Unit1

import android.os.Bundle
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

import com.anshuman.andriodcse225allcode.R

class IntentsDisplay : AppCompatActivity() {

    // Todo 2 how to get the data from the sting and store it  in the activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_intents_display)

        val display = findViewById<TextView>(R.id.textdisplay)

        val email =  intent.getStringExtra("email")
        val password= intent.getStringExtra("password")


        display.text = buildString {
            append("hey welcome to the my page :${email} \n")
            append("and  your password is ${password}   ")
        }

    }
}