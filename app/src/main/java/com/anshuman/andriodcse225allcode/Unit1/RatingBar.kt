package com.anshuman.andriodcse225allcode.Unit1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import android.widget.RatingBar

import androidx.appcompat.app.AppCompatActivity

import com.anshuman.andriodcse225allcode.R

class RatingBar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_rating_bar)


        val qualityRatingBar = findViewById<RatingBar>(R.id.ratingBar_quality)
        val serviceRatingBar = findViewById<RatingBar>(R.id.ratingBar_services)
        val approachRatingBar = findViewById<RatingBar>(R.id.ratingBar_approach)
        val calculateButton = findViewById<Button>(R.id.button_avg)
        val averageTextView = findViewById<TextView>(R.id.result)

        calculateButton.setOnClickListener{
            val qualityRating = qualityRatingBar.rating
            val serviceRating = serviceRatingBar.rating
            val approachRating = approachRatingBar.rating

            val avg_rating = (qualityRating + serviceRating + approachRating) / 3.0

            averageTextView.text = "Average rating is : $avg_rating"
        }

    }
}