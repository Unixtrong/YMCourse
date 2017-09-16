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

import static com.huangshan.demo.utils.Tools.dipToPixel;

/**
 * Author(s): danyun
 * Date: 2017/9/17
 */
public class L45ProgressView extends View {

    private Paint mPaint = new Paint();
    private RectF mRectF = new RectF();
    private float mRadius = dipToPixel(80);
    private int mProgress;

    public L45ProgressView(Context context) {
        super(context);
    }

    public L45ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public L45ProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(dipToPixel(30));
        mPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(dipToPixel(15));
        mPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        mRectF.set(centerX - mRadius, centerY - mRadius, centerX + mRadius, centerY + mRadius);
        canvas.drawArc(mRectF, 120, mProgress * 3.6F, false, mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(dipToPixel(2));
        canvas.drawText(mProgress + "%", centerX, centerY + mPaint.descent(), mPaint);
    }

    public int getProgress() {
        return mProgress;
    }

    public L45ProgressView setProgress(int progress) {
        mProgress = progress;
        invalidate();
        return this;
    }
}
