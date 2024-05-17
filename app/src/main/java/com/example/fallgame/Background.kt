package com.example.fallgame

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect

class Background(context: Context, bitmap: Bitmap, posX: Float, posY: Float,
                 vGravity: Float, speed: Float) :
    DynamicBody(context, bitmap, posX, posY, vGravity, speed) {

    private val bitmapList: List<Bitmap>

    init {
        bitmapList = listOf(bitmap, bitmap, bitmap)
    }
    override fun bounds(bounds: Rect) {
    }

    override fun draw(canvas: Canvas?) {
        for (i in 0..bitmapList.size) {
            canvas?.drawBitmap(bitmap, posX, posY+bitmap.height*i, null)
        }
    }
    private fun getPixelHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }

    override fun update() {
        val offset = bitmap.height
        posY -= vGravity
        if (posY < -offset) {
            posY += offset
        }
    }
}
