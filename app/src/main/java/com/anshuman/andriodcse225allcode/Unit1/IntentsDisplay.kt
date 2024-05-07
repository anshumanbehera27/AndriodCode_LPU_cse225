package com.anshuman.andriodcse225allcode.Unit1

import android.content.Context
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
    // todo  this will done withe the help of the intent

//        val email =  intent.getStringExtra("email")
//        val password= intent.getStringExtra("password")

        // todo Retrieve email and password from SharedPreferences
        val sharedPreferences = getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE)
        val email = sharedPreferences.getString("email", "")
        val password = sharedPreferences.getString("password", "")

        display.text = buildString {
            append("hey welcome to the my page :${email} \n")
            append("and  your password is ${password}   ")
        }

    }
}