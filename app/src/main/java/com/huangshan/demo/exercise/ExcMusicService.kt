package com.huangshan.demo.exercise

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Environment
import android.os.IBinder
import com.huangshan.demo.consts.MusicActions
import com.huangshan.demo.utils.debug
import java.io.File

/**
 * Author(s): danyun
 * Date: 2017/5/13
 */
class ExcMusicService : Service() {
    private var isRelease = true
    var player: MediaPlayer? = null
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            MusicActions.PLAY -> play()
            MusicActions.PAUSE -> pause()
            MusicActions.STOP -> stop()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun play() {
        if (isRelease) {
            val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), "mafei.mp3")
            debug("length: ${file.length()} path: " + file.absolutePath)
            if (file.exists()) {
//            player = MediaPlayer.create(this, R.raw.damage)
                player = MediaPlayer()
                player?.let {
                    it.setDataSource(file.absolutePath)
                    it.prepare()
                    debug("duration: ${it.duration}")
                    isRelease = false
                }
            }
        }
        player?.start()
        debug("start")
    }

    private fun pause() {
        player?.pause()
        debug("pause")
    }

    private fun stop() {
        player?.reset()
        player?.release()
        isRelease = true
        debug("reset")
    }
}