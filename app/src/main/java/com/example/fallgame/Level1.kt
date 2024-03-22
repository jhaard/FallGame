package com.example.fallgame

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.view.SurfaceHolder

open class Level1(private val context: Context): Scene() {
     private lateinit var player: Player


     override fun start(holder: SurfaceHolder) {
          player = Player(context, holder.surfaceFrame.width().toFloat()/2,
               holder.surfaceFrame.height().toFloat()/2, 100f, 0f, 0f)

     }
     override fun update(holder: SurfaceHolder) {
          val canvas: Canvas? = holder.lockCanvas()
          canvas?.drawColor(Color.GREEN)
          player.draw(canvas)
          holder.unlockCanvasAndPost(canvas)
     }

     override fun stop() {

     }

}