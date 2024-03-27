package com.example.fallgame

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import kotlin.math.ceil

class Background(context: Context, posX: Float, posY: Float, size: Float, speed: Float,
                 vGravity: Float
) :
    DynamicBody(context, posX, posY, size, speed, vGravity) {

    private var bitmap: Bitmap
    private var bitmap2: Bitmap
    private val sizable = BitmapFactory.Options()

    private var tiles: Double
    private val imageHeight: Int

    init {
        sizable.inSampleSize = 10
        bitmap = BitmapFactory.decodeResource(
            context.resources,
            R.drawable.test_background4
        )
        bitmap2 = BitmapFactory.decodeResource(
            context.resources,
            R.drawable.test_background4
        )
        imageHeight = bitmap.height
        tiles = ceil((getHeight() / imageHeight).toDouble())
    }
    override fun bounds(bounds: Rect) {
    }

    override fun draw(canvas: Canvas?) {
        canvas?.drawBitmap(bitmap, posX, posY, null)
        canvas?.drawBitmap(bitmap2, posX, posY + bitmap.height, null)
        if (bitmap.height < 0) {
            canvas?.drawBitmap(bitmap, posX, posY + bitmap2.height, null)
        }
    }

    private fun getHeight(): Int {
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
