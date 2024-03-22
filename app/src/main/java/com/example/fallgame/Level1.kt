package com.example.fallgame

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.view.SurfaceHolder

open class Level1(private val context: Context): Scene() {
     private lateinit var player: Player
     private lateinit var background: Background


     override fun start(holder: SurfaceHolder) {
          player = Player(context, holder.surfaceFrame.width().toFloat()/2,
               holder.surfaceFrame.height().toFloat()/2, 100f, 0f, 5f)
          background = Background(context, holder.surfaceFrame.width().toFloat()/2,
               holder.surfaceFrame.height().toFloat()/2, 0f)

     }
     override fun draw(holder: SurfaceHolder) {
          val canvas: Canvas? = holder.lockCanvas()
          background.draw(canvas)
          player.draw(canvas)
          holder.unlockCanvasAndPost(canvas)
     }

     override fun update() {
          player.update()
     }

     override fun stop() {

     }

}