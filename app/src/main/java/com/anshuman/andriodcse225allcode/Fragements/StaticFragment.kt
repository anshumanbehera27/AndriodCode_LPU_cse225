package com.anshuman.andriodcse225allcode.Fragements

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.anshuman.andriodcse225allcode.R

class StaticFragment : AppCompatActivity() {
    private lateinit var btn1 :Button
    private lateinit var btn2:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_static_fragment)

        btn1 = findViewById(R.id.btnFragmentA)
        btn2 = findViewById(R.id.btnFragmentB)

        // Set click listeners for the buttons
        btn1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FragmentA())
                .commit()
        }

        btn2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FragmentB())
                .commit()
        }



    }
}