package com.huangshan.demo.ui;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.huangshan.demo.R;
import com.huangshan.demo.ui.view.L45ProgressView;

public class L45AnimActivity extends AppCompatActivity {

    private ImageView mFrameImageView;
    private ImageView mTweenImageView;
    private int mAnimState;
    private int mPropertyAnimState;
    private AnimationDrawable mFrameAnimDraw;
    private Animation mTweetRotateAnim;
    private Animation mAnimSet;
    private ImageView mPropertyImageView;
    private L45ProgressView mL45ProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l45_anim);

        mFrameImageView = (ImageView) findViewById(R.id.l45_iv_frame);
        mTweenImageView = (ImageView) findViewById(R.id.l45_iv_tween);
        mPropertyImageView = (ImageView) findViewById(R.id.l45_iv_property);
        mL45ProgressView = (L45ProgressView) findViewById(R.id.l45_pv);
        mFrameAnimDraw = (AnimationDrawable) mFrameImageView.getDrawable();
        mTweetRotateAnim = AnimationUtils.loadAnimation(this, R.anim.anim_l45_rotate);
        mAnimSet = AnimationUtils.loadAnimation(this, R.anim.anim_l45_set);
    }

    public void start(View view) {
        switch (mAnimState++) {
            case 0:
                mFrameAnimDraw.start();
                break;
            case 1:
                mFrameAnimDraw.stop();
                break;
            case 2:
                mTweenImageView.startAnimation(mTweetRotateAnim);
                break;
            case 3:
                mTweenImageView.clearAnimation();
                break;
            case 4:
                mTweenImageView.startAnimation(mAnimSet);
                break;
            case 5:
                mTweenImageView.clearAnimation();
                break;
            case 6:
                mPropertyImageView.animate().translationXBy(500F);
                break;
            case 7:
                mPropertyImageView.animate().translationXBy(-500F).setDuration(3000).setInterpolator(new FastOutLinearInInterpolator());
                break;
            case 8:
                ObjectAnimator animator = ObjectAnimator.ofFloat(mPropertyImageView, "translationX", 500);
                animator.start();
                mAnimState = 0;
                break;
        }
    }

    public void startProperty(View view) {
        switch (mPropertyAnimState++) {
            case 0:
                ObjectAnimator animator = ObjectAnimator.ofInt(mL45ProgressView, "progress", 87);
                animator.setDuration(3000);
                animator.start();
                break;
            case 1:
                ObjectAnimator animator2 = ObjectAnimator.ofInt(mL45ProgressView, "progress", 0);
                animator2.setDuration(3000);
                animator2.start();
                mPropertyAnimState = 0;
                break;
        }
    }
}
