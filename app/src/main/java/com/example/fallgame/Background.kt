package com.example.fallgame

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect

class Background(context: Context, posX: Float, posY: Float, size: Float, speed: Float,
                 vGravity: Float
) :
    DynamicBody(context, posX, posY, size, speed, vGravity) {
    private var bitmap: Bitmap
    private val bitmapList: List<Bitmap>
    private val sizable = BitmapFactory.Options()

    init {
        sizable.inSampleSize = 10
        bitmap = BitmapFactory.decodeResource(
            context.resources,
            R.drawable.test_background4
        )
        bitmapList = listOf(
            BitmapFactory.decodeResource(context.resources, R.drawable.test_background4),
            BitmapFactory.decodeResource(context.resources, R.drawable.test_background4),
            BitmapFactory.decodeResource(context.resources, R.drawable.test_background4))
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
