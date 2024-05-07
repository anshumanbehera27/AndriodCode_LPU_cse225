package com.anshuman.andriodcse225allcode.unit2

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Button

import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.anshuman.andriodcse225allcode.MainActivity

import com.anshuman.andriodcse225allcode.R
import com.anshuman.andriodcse225allcode.Unit1.IntentsDisplay
import android.Manifest


class notifaction : AppCompatActivity() {
    val channel_id = "ChannelID"
    val channel_name = "channelName"
    val notifiction_id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifaction)
        val btnShowNotifaction = findViewById<Button>(R.id.noti)
        /*
          1st step is to create a notification channel
          2nd steps is
         */
        createNotificationChannel()

        // create an pending ineten
        val intent = Intent(this ,IntentsDisplay::class.java )
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0 , PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notifiction = NotificationCompat.Builder(this , channel_id)
            .setContentTitle("Awesome notifiction")
            .setContentText("This is the content text")
            .setSmallIcon(R.drawable.notification)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)

        btnShowNotifaction.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.

            }
            notificationManager.notify(notifiction_id , notifiction)
        }
    }

    fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(channel_id , channel_name ,
                NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor = Color.GREEN
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }

    }

    }
