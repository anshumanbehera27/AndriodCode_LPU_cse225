package com.anshuman.andriodcse225allcode

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class videoView : AppCompatActivity() {
    private lateinit var videoView: VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_video_view)

        videoView = findViewById(R.id.video_view)
        val playButton: Button = findViewById(R.id.play_button)

        // Set the path of the video file or URL
        val videoPath = "android.resource://${packageName}/${R.raw.video_file}"

        // Set media controller for playback control
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        // Set the video URI
        val videoUri = Uri.parse(videoPath)
        videoView.setVideoURI(videoUri)

        playButton.setOnClickListener {
            // Start playing the video
            videoView.start()
        }

    }
}