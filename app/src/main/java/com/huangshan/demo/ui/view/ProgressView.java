package com.huangshan.demo.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.huangshan.demo.R;

import static com.huangshan.demo.utils.Tools.debug;
import static com.huangshan.demo.utils.Tools.dipToPixel;

/**
 * Author(s): danyun
 * Date: 2017/9/16
 */
public class ProgressView extends View {
    final float mRadius = dipToPixel(80);

    RectF mRectF = new RectF();
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    int mProgress = 0;

    public ProgressView(Context context) {
        super(context);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setTextSize(dipToPixel(40));
        mPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;

        mPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(dipToPixel(15));
        mRectF.set(centerX - mRadius, centerY - mRadius, centerX + mRadius, centerY + mRadius);
        canvas.drawArc(mRectF, 0, mProgress * 3.6F, false, mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        debug("x: " + centerX + " y: " + centerY + " a: " + mPaint.ascent() + " d: " + mPaint.descent());
        canvas.drawText(mProgress + "%Ajg好", centerX, centerY, mPaint);

        mPaint.setStrokeWidth(dipToPixel(1));
        mPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        canvas.drawLine(mRectF.left, centerY, mRectF.right, centerY, mPaint);
    }

    public int getProgress() {
        return mProgress;
    }

    public ProgressView setProgress(int progress) {
        this.mProgress = progress;
        invalidate();
        return this;
    }
}
