package com.anshuman.andriodcse225allcode.Traffic_light

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anshuman.andriodcse225allcode.R

class Activity_traffic_light : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_traffic_light)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, TrafficLightFragment())
            .commit()


    }
}