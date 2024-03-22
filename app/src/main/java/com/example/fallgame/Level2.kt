package com.example.fallgame

import android.graphics.Canvas
import android.graphics.Color
import android.view.SurfaceHolder

class Level2: Scene() {

    override fun start(holder: SurfaceHolder) {
        val canvas: Canvas? = holder.lockCanvas()
        canvas?.drawColor(Color.BLUE)

        holder.unlockCanvasAndPost(canvas)
    }

    override fun stop() {

    }
}