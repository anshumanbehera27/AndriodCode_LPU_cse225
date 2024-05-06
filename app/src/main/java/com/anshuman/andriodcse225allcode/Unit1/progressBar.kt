package com.anshuman.andriodcse225allcode.Unit1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import com.anshuman.andriodcse225allcode.R

class progressBar : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val progressBarround = findViewById<ProgressBar>(R.id.progressBar)
        val  progressBarhorizontal = findViewById<ProgressBar>(R.id.progressBar2)
        val  button = findViewById<Button>(R.id.button)

        button.setOnClickListener{
            val rate = ratingBar.rating

            progressBarround.progress = (rate * 20).toInt()
            progressBarhorizontal.progress = (rate * 20).toInt()
        }




    }
}