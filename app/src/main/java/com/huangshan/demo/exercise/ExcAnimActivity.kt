package com.huangshan.demo.exercise

import android.animation.ObjectAnimator
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.huangshan.demo.R
import com.huangshan.demo.ui.view.ProgressView
import com.huangshan.demo.utils.Tools.dipToPixel

class ExcAnimActivity : AppCompatActivity() {

    lateinit var mFrameImageView: ImageView
    lateinit var mTweenImageView: ImageView
    lateinit var mProgressImageView: ProgressView
    lateinit var mAnimFrame: AnimationDrawable
    lateinit var mAnimTween: Animation
    var mAnimState: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exc_anim)

        mFrameImageView = findViewById(R.id.l45_iv_frame) as ImageView
        mTweenImageView = findViewById(R.id.l45_iv_tween_anim) as ImageView
        mProgressImageView = findViewById(R.id.l45_pv_anim) as ProgressView
        mAnimFrame = mFrameImageView.drawable as AnimationDrawable
        mAnimTween = AnimationUtils.loadAnimation(this, R.anim.anim_set)
    }

    fun startAnim(view: View) {
        when (mAnimState++) {
            0 -> {
                mAnimFrame.start()
            }

            1 -> {
                if (mAnimFrame.isRunning) {
                    mAnimFrame.stop()
                }
            }

            2 -> {
                mTweenImageView.startAnimation(mAnimTween)
            }

            3 -> {
                mTweenImageView.clearAnimation()
            }

            4 -> {
                mTweenImageView.animate().translationYBy(300F).start()
            }

            5 -> {
                mTweenImageView.animate().translationYBy(-300F).start()
            }

            6 -> {
                val animator = ObjectAnimator.ofInt(mProgressImageView, "progress", 0, 100)
                animator.duration = 1000L
                animator.start()
                mAnimState = 0
            }
        }

    }
}
