package com.example.loop

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.widget.VideoView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val videoView = findViewById<VideoView>(R.id.video)
        val videoUri = Uri.parse("android.resource://${packageName}/${R.raw.z}")

        videoView.setVideoURI(videoUri)

        videoView.setOnPreparedListener { mp ->
            mp.isLooping = true
            videoView.start()
        }

        videoView.setOnErrorListener { _, what, extra ->
            android.util.Log.e("VideoView", "Error: what=$what extra=$extra")
            true
        }
    }
}