package com.huangshan.demo.exercise

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.huangshan.demo.R
import com.huangshan.demo.consts.MusicActions
import com.huangshan.demo.utils.debug
import java.io.File

class ExcMusicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exc_music)
    }

    fun play(v: View) {
        startService(Intent(this, ExcMusicService::class.java).apply { action = MusicActions.PLAY })
        debug("start")
    }

    fun pause(v: View) {
        startService(Intent(this, ExcMusicService::class.java).apply { action = MusicActions.PAUSE })
        debug("pause")
    }

    fun stop(v: View) {
        startService(Intent(this, ExcMusicService::class.java).apply { action = MusicActions.STOP })
        debug("reset")
    }

    fun startService(v: View) {
        val intent = Intent(this, ExcMusicService::class.java)
        startService(intent)
    }
}
