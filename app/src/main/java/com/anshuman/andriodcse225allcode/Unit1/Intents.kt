package com.anshuman.andriodcse225allcode.Unit1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.anshuman.andriodcse225allcode.R

class Intents : AppCompatActivity() {
    // Todo 1 Apply the explicit intents
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)
        val res = findViewById<TextView>(R.id.textView2)
        val email = findViewById<EditText>(R.id.edemail)
        val password = findViewById<EditText>(R.id.edpassword)
        val button = findViewById<Button>(R.id.button1)


        // TODO data transfer with the help of the intents

//        button.setOnClickListener{
//            val a1 = email.text.toString()
//            val a2 = password.text.toString()
//            // you need to check for the null value
//            if(a1.isEmpty() || a2.isEmpty()){
//                res.text = "Enter your all text"
//            }
//            else
//            {
//                val  intent = Intent(this , IntentsDisplay::class.java)
//                intent.putExtra("email" , a1)
//                intent.putExtra("password" , a2)
//                startActivity(intent)
//
//
//            }
//        }
        // TODO data transfer with the help of the SharedPreferences
        button.setOnClickListener {
            val a1 = email.text.toString()
            val a2 = password.text.toString()
            // you need to check for the null value
            if (a1.isEmpty() || a2.isEmpty()) {
                res.text = "Enter your all text"

            } else {
                saveLoginData(a1 , a2)
                startActivity(Intent(this , IntentsDisplay::class.java))


            }

        }
    }
    private fun saveLoginData(email: String, password: String) {
        val sharedPreferences = getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("email", email)
        editor.putString("password", password)
        editor.apply()
    }
}