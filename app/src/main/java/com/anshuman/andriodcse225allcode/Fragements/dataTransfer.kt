package com.anshuman.andriodcse225allcode.Fragements

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import com.anshuman.andriodcse225allcode.R

class dataTransfer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_data_transfer)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, FragmentA())
                .commit()
        }

    }
}