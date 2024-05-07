package com.anshuman.andriodcse225allcode.unit2

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import com.anshuman.andriodcse225allcode.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Alarammanager : AppCompatActivity() {

    private lateinit var alarmManager: AlarmManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_alarammanager)
        val editTextTime: EditText = findViewById(R.id.editTextTime)
        val btnSetAlarm: Button = findViewById(R.id.btnSetAlarm)
        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

        btnSetAlarm.setOnClickListener {
            val timeString = editTextTime.text.toString()

            if (timeString.isNotEmpty()) {
                val calendar = Calendar.getInstance()
                val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
                val alarmTime = sdf.parse(timeString)

                if (alarmTime != null) {
                    calendar.time = alarmTime
                    setAlarm(calendar)
                } else {
                    Toast.makeText(this, "Invalid time format", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter a time", Toast.LENGTH_SHORT).show()
            }

        }
    }
    private fun setAlarm(calendar: Calendar) {
        val intent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)

        Toast.makeText(
            this,
            "Alarm set for ${SimpleDateFormat("HH:mm", Locale.getDefault()).format(calendar.time)}",
            Toast.LENGTH_SHORT
        ).show()
    }
}