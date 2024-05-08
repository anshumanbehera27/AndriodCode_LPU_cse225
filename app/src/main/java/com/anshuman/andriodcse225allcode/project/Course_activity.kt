package com.anshuman.andriodcse225allcode.project

import CourseAdapter
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.anshuman.andriodcse225allcode.R

class Course_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_course)
        val courses = listOf(
            Course("dsa-to-development-coding-guide", "anshuman", "6 weeks"),
            Course("full-stack-applied-data-science-program", "sandeep jain", "8 weeks"),
            Course("Java-backend-live", "arsh goyal", "10 weeks"),
            // Add more courses as needed
        )
        val adapter = CourseAdapter(this, courses)
        val listView = findViewById<ListView>(R.id.list_courses)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedCourse = courses[position]
            showToast("You selected: ${selectedCourse.name}")
        }

    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}