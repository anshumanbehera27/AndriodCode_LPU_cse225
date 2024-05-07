package com.anshuman.andriodcse225allcode.unit2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.widget.Toast
import com.anshuman.andriodcse225allcode.R

class AlarmReceiver : BroadcastReceiver() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onReceive(context: Context?, intent: Intent?) {
        // Handle the alarm action here
        Toast.makeText(context, "Alarm triggered!", Toast.LENGTH_SHORT).show()

        // Play the alarm sound
        playAlarmSound(context)

        // For example, you can display a notification or start an activity
    }

    private fun playAlarmSound(context: Context?) {
        // Release any existing media player
        mediaPlayer?.release()

        // Create a new media player and load the alarm sound from the raw folder
        mediaPlayer = MediaPlayer.create(context, R.raw.alaram_sound)

        // Set looping to true to play the sound repeatedly until stopped
        mediaPlayer?.isLooping = true

        // Start playback
        mediaPlayer?.start()
    }
}