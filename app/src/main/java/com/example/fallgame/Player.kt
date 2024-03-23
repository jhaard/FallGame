package com.example.fallgame

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect

class Player(context: Context, posX: Float, posY: Float, size: Float, speed: Float, vGravity: Float):
    DynamicBody(context, posX, posY, size, speed, vGravity) {

    private var bitmap: Bitmap
    private val sizable = BitmapFactory.Options()


    init {
        sizable.inSampleSize = 14
        bitmap = BitmapFactory.decodeResource(
            context.resources,
            R.drawable.rockfall_player_400)
    }
    override fun bounds(bounds: Rect) {
        //TODO("Not yet implemented")
    }

    override fun draw(canvas: Canvas?) {
        val centerX = posX - bitmap.width / 2
        val centerY = posY - bitmap.height / 2

        canvas?.drawBitmap(bitmap, centerX, centerY, null)
    }

    override fun update() {
        if (posY <= 1900f) {
            posY += vGravity
            if(posY == 1900f) {
                posY = 0f
            }
        }
    }
}