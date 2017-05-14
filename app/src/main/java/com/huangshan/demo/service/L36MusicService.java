package com.huangshan.demo.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.huangshan.demo.consts.MusicActions;
import com.huangshan.demo.utils.Tools;

import java.io.File;
import java.io.IOException;

public class L36MusicService extends Service implements MediaPlayer.OnCompletionListener {
    private boolean mNeedSetSource = true;
    private MediaPlayer mMediaPlayer;

    public L36MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Tools.debug("onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Tools.debug("onStartCommand");
        String action = intent.getAction();
        switch (action) {
            case MusicActions.PLAY:
                play(intent.getStringExtra("path"));
                break;
            case MusicActions.PAUSE:
                pause();
                break;
            case MusicActions.STOP:
                stop();
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Tools.debug("onDestroy");
        super.onDestroy();
    }

    private void play(String path) {
        File file = new File(path);
        if (mNeedSetSource) {
            try {
                if (file.exists()) {
                    mMediaPlayer = new MediaPlayer();
                    mMediaPlayer.setOnCompletionListener(this);
                    mMediaPlayer.setDataSource(path);
                    mMediaPlayer.prepare();
                    mNeedSetSource = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        mMediaPlayer.start();
    }

    private void pause() {
        if (!mNeedSetSource) {
            mMediaPlayer.pause();
        }
    }

    private void stop() {
        mMediaPlayer.reset();
        mMediaPlayer.release();
        mNeedSetSource = true;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        stop();
    }
}
