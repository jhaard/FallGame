package com.example.fallgame

import android.graphics.Canvas
import android.graphics.Color
import android.view.SurfaceHolder

open class Level1: Scene() {

     override fun start(holder: SurfaceHolder) {
          val canvas: Canvas? = holder.lockCanvas()
          canvas?.drawColor(Color.GREEN)

          holder.unlockCanvasAndPost(canvas)
     }

     override fun stop() {

     }

}