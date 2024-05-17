package com.example.fallgame

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect

class Enemy(context: Context, bitmap: Bitmap, posX: Float, posY: Float,
            vGravity: Float, speed: Float, private var rightSide: Boolean):
    DynamicBody(context, bitmap,  posX, posY, vGravity, speed) {
    override fun bounds(bounds: Rect) {

    }

    override fun draw(canvas: Canvas?) {
        val centerX = posX - bitmap.width / 2
        val centerY = posY - bitmap.height / 2

        canvas?.drawBitmap(bitmap, centerX, centerY, null)
    }

    override fun update() {
        if (rightSide) {
            posX += speed
            posY += -vGravity
        } else {
            posX -= speed
            posY += -vGravity
        }

    }

}