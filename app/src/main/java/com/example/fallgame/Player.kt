package com.example.fallgame

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect

class Player(context: Context, bitmap: Bitmap, posX: Float, posY: Float, vGravity: Float, speed: Float):
    DynamicBody(context, bitmap,  posX, posY, vGravity, speed) {

    override fun bounds(bounds: Rect) {
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