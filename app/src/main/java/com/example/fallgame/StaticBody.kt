package com.example.fallgame

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas

abstract class StaticBody(var context: Context, var bitmap: Bitmap, var posX: Float, var posY: Float) {
    abstract fun draw(canvas: Canvas?)
}