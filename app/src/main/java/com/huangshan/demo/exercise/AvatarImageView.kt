package com.huangshan.demo.exercise

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.ImageView
import com.huangshan.demo.R
import com.huangshan.demo.utils.debug

class AvatarImageView : ImageView {

    val mPath = Path()
    val mBitmap: Bitmap = BitmapFactory.decodeResource(context.resources, R.mipmap.image_first)
    val mXfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    val mPaint = Paint().apply {
        isAntiAlias = true
        color = Color.RED
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, set: AttributeSet) : super(context, set)
    constructor(context: Context, set: AttributeSet, defStyle: Int) : super(context, set, defStyle)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val xCenter = width / 2F
        val yCenter = height / 2F
        mPath.addCircle(xCenter, yCenter, xCenter, Path.Direction.CW)
        debug("avatar, x: $xCenter, y: $yCenter")

        canvas?.let {
            it.save()
            it.clipPath(mPath)
            it.drawBitmap(mBitmap, 0F, 0F, mPaint)
            it.restore()
        }
    }
}