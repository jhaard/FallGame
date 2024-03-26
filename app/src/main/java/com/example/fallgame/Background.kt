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
    private val sizable = BitmapFactory.Options()

    private var tiles: Double
    private val imageHeight: Int

    init {
//        sizable.inSampleSize = 10
        bitmap = BitmapFactory.decodeResource(
            context.resources,
            R.drawable.test_background4
        )
        imageHeight = bitmap.height
        tiles = ceil((getHeight() / imageHeight).toDouble())
    }
    override fun bounds(bounds: Rect) {
    }

    override fun draw(canvas: Canvas?) {
//        println(imageHeight)
//        println(getHeight())

//        for (i in 0..tiles.toInt()) {
//            posY = i*imageHeight.toFloat()
            canvas?.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR)
            canvas?.drawBitmap(bitmap, posX, posY, null)
//        }

    }

    private fun getHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }

    override fun update() {
//        posY -= vGravity

//        val offset = getHeight()
//        tiles -= vGravity
//        if (tiles < -offset) {
//            tiles += offset
//        }


//

        posY -= vGravity
        if (posY < -getHeight()) {
            posY = getHeight().toFloat()
        }
    }
}
