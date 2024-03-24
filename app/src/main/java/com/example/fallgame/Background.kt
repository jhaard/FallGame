package com.example.fallgame

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect

class Background(val context: Context, posX: Float, posY: Float, size: Float, speed: Float,
                 vGravity: Float
) :
    DynamicBody(context, posX, posY, size, speed, vGravity) {

    private var bitmap: Bitmap
    private val sizable = BitmapFactory.Options()

    init {
        sizable.inSampleSize = 14
        bitmap = BitmapFactory.decodeResource(
            context.resources,
            R.drawable.test_background4
        )
    }
    override fun bounds(bounds: Rect) {
    }

    override fun draw(canvas: Canvas?) {
        canvas?.drawBitmap(bitmap, posX, posY, null)
    }

    private fun getHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }

    override fun update() {
        posY -= vGravity
        if (posY < -getHeight()) {
            posY = getHeight().toFloat()
        }
    }
}
