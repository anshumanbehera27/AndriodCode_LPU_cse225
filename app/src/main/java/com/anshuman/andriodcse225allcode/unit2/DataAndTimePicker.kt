package com.anshuman.andriodcse225allcode.unit2

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.anshuman.andriodcse225allcode.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DataAndTimePicker : AppCompatActivity() {
    private lateinit var txtSelectedDate : TextView
    private lateinit var txtSelectedTime : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_data_and_time_picker)

        val btnDatePicker: Button = findViewById(R.id.btndatePicker)
        val btnTimePicker: Button = findViewById(R.id.btnTimePicker)
        txtSelectedDate = findViewById(R.id.tvDateSelected)
        txtSelectedTime = findViewById(R.id.tvTimeselected)

        btnDatePicker.setOnClickListener {
            showDatePickerDialog()
        }

        btnTimePicker.setOnClickListener {
            showTimePickerDialog()
        }


    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = formatDate(selectedDay, selectedMonth, selectedYear)
                txtSelectedDate.text = selectedDate
                Toast.makeText(this, "Selected Date: $selectedDate", Toast.LENGTH_SHORT).show()
            },
            year,
            month,
            dayOfMonth
        )

        datePickerDialog.show()
    }
    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { _, selectedHour, selectedMinute ->
                val selectedTime = formatTime(selectedHour, selectedMinute)
                txtSelectedTime.append(" $selectedTime")
                Toast.makeText(this, "Selected Time: $selectedTime", Toast.LENGTH_SHORT).show()
            },
            hourOfDay,
            minute,
            true // Set true for 24-hour time format, false for 12-hour format
        )

        timePickerDialog.show()
    }

    private fun formatDate(day: Int, month: Int, year: Int): String {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }

    private fun formatTime(hour: Int, minute: Int): String {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minute)
        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        return timeFormat.format(calendar.time)
    }

}