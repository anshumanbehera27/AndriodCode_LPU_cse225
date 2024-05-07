package com.anshuman.andriodcse225allcode.unit2

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyJobService : JobService() {

    override fun onStartJob(params: JobParameters?): Boolean {
        Log.d("TAG", "onStartJob:")
        val intent = Intent(this@MyJobService, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            this@MyJobService,
            234,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pendingIntent)
        Toast.makeText(this@MyJobService, "Alarm Set ", Toast.LENGTH_LONG).show()
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("TAG", "onStopJob:")
        return true
    }
}
