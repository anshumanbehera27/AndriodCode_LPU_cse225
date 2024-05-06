package com.anshuman.andriodcse225allcode.Unit1

import android.os.Bundle
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

import com.anshuman.andriodcse225allcode.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNav : AppCompatActivity() {
    private lateinit var res: TextView
    private lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_bottom_nav)
        // this is show which one you are selecting
        res = findViewById(R.id.ttview)
        bottomNav = findViewById(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.menu_home -> {
                    res.text = "Home"
                    true
                }

                R.id.menu_profile -> {
                    res.text = "profile"
                    true
                }

                R.id.menu_notification -> {
                    res.text = "Notifaction"
                    true
                }

                R.id.menu_search -> {
                    res.text = "Serach"
                    true
                }

                else -> {
                    true
                }
            }


        }
    }
}