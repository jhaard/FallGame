package com.example.fallgame

import android.content.Context
import android.graphics.Canvas

abstract class StaticBody(context: Context, var posX: Float, var posY: Float, var size: Float) {
    abstract fun draw(canvas: Canvas?)
}