package com.anshuman.andriodcse225allcode

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity


class deatils_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_deatils_page)
        val restaurantNameTextView = findViewById<TextView>(R.id.restaurantName)
        val  restaurantDescriptionTextView = findViewById<TextView>(R.id.restaurantDescription)
        val  restaurantImageView = findViewById<ImageView>(R.id.restaurantImage)

        // Retrieve data passed from previous activity
        val restaurantId = intent.getIntExtra("restaurantId", 0)
        val restaurantName = intent.getStringExtra("restaurantName")
        val restaurantDescription = intent.getStringExtra("restaurantDescription")

        // Set data to views
        restaurantNameTextView.text = restaurantName
        restaurantDescriptionTextView.text = restaurantDescription

        // set the image data
        val imageresource = when(restaurantId){
            R.id.restaurant1 -> R.drawable.res1
            R.id.restaurant2 -> R.drawable.res2
            R.id.restaurant3 -> R.drawable.res3
            R.id.restaurant4 -> R.drawable.res4
            R.id.restaurant5 -> R.drawable.res5

            else -> R.drawable.res1
        }
        restaurantImageView.setImageResource(imageresource)

    }
}