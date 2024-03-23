package com.example.fallgame

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas

class Background(context: Context, posX: Float, posY: Float, size: Float) :
    StaticBody(context, posX, posY, size) {

    private var bitmap: Bitmap
    private val sizable = BitmapFactory.Options()

    init {
        sizable.inSampleSize = 14
        bitmap = BitmapFactory.decodeResource(
            context.resources,
            R.drawable.test_background
        )
    }

    override fun draw(canvas: Canvas?) {
        val centerX = posX - bitmap.width / 2
        val centerY = posY - bitmap.height / 2

        canvas?.drawBitmap(bitmap, centerX, centerY, null)
    }
}