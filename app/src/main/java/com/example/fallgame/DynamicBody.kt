package com.example.fallgame

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect

abstract class DynamicBody(
    var context: Context, var bitmap: Bitmap, var posX: Float, var posY: Float,
    var vGravity: Float, var speed: Float) {

    abstract fun bounds(bounds: Rect)
    abstract fun draw(canvas: Canvas?)
    abstract fun update()


}