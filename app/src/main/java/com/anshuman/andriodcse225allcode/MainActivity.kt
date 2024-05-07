package com.anshuman.andriodcse225allcode

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


    }
    fun onRestaurantClick(view: View) {
        // Determine which restaurant was clicked based on its ID
        val restaurantId = view.id

        // Get restaurant details based on its ID
        val restaurantName = when (restaurantId) {
            R.id.restaurant1 -> "Restaurant 1"
            R.id.restaurant2 -> "Restaurant 2"
            R.id.restaurant3 -> "Restaurant 3"
            R.id.restaurant4 -> "Restaurant 4"
            R.id.restaurant5 -> "Restaurant 5"

            else -> "Unknown Restaurant"
        }

        val restaurantDescription = "This is a description for $restaurantName."

        // Start RestaurantDetailActivity and pass restaurant details
        val intent = Intent(this, deatils_page::class.java)
        intent.putExtra("restaurantId", restaurantId)
        intent.putExtra("restaurantName", restaurantName)
        intent.putExtra("restaurantDescription", restaurantDescription)
        startActivity(intent)
    }
}