package com.example.fallgame

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect

abstract class DynamicBody (context: Context, var posX: Float, var posY: Float,
                            var size: Float, var speed: Float, var vGravity: Float) {

    abstract fun bounds(bounds: Rect)
    abstract fun draw(canvas: Canvas?)
    abstract fun update()


}