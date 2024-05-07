package com.anshuman.andriodcse225allcode.unit2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button

import androidx.appcompat.app.AppCompatActivity

import com.anshuman.andriodcse225allcode.R

class Activity_toast : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_toast)

        val  btn = findViewById<Button>(R.id.button_toast)

        btn.setOnClickListener{
            CustomToast.showToast(this, "This is a custom Toast!")
        }

    }
}