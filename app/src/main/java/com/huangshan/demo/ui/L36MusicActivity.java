package com.huangshan.demo.ui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.huangshan.demo.R;
import com.huangshan.demo.consts.MusicActions;
import com.huangshan.demo.service.L36MusicService;
import com.huangshan.demo.utils.Tools;

import java.io.File;
import java.io.IOException;

public class L36MusicActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private TextView mPathTextView;
    private TextView mSizeTextView;
    private TextView mDurationTextView;
    private String mFilePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l36_music);
        mPathTextView = (TextView) findViewById(R.id.l36_tv_path);
        mSizeTextView = (TextView) findViewById(R.id.l36_tv_size);
        mDurationTextView = (TextView) findViewById(R.id.l36_tv_duration);

        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("");
        initPlayer();
    }

    private void initPlayer() {
        File parent = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        String[] fileNameList = parent.list();
        for (int i = 0; i < fileNameList.length; i++) {
            Tools.debug("file: " + fileNameList[i]);
        }

        File file = new File(parent, "mafei.mp3");
        mFilePath = file.getAbsolutePath();
        mPathTextView.setText("路径：" + mFilePath);
        mSizeTextView.setText("大小：" + (file.length() / 1024.00F) + "k");
        try {
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setDataSource(mFilePath);
            mMediaPlayer.prepare();
            mDurationTextView.setText("时长：" + (mMediaPlayer.getDuration() / 1000.00F) + "\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
        mMediaPlayer.release();
    }

    public void play(View view) {
        Tools.debug("L36MusicActivity play");
        Intent intent = new Intent(this, L36MusicService.class);
        intent.setAction(MusicActions.PLAY);
        intent.putExtra("path", mFilePath);
        startService(intent);
    }

    public void pause(View view) {
        Tools.debug("L36MusicActivity pause");
        Intent intent = new Intent(this, L36MusicService.class);
        intent.setAction(MusicActions.PAUSE);
        startService(intent);
    }

    public void stop(View view) {
        Intent intent = new Intent(this, L36MusicService.class);
        Tools.debug("L36MusicActivity stop");
        intent.setAction(MusicActions.STOP);
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(this, L36MusicService.class);
        Tools.debug("L36MusicActivity stop service");
        intent.setAction(MusicActions.STOP_SERVICE);
        startService(intent);
    }
}
