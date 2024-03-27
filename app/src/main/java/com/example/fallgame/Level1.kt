package com.example.fallgame

import android.content.Context
import android.graphics.Canvas
import android.view.SurfaceHolder

open class Level1(private val context: Context) : Scene() {
    lateinit var player: Player
    lateinit var background: Background

    override fun start(holder: SurfaceHolder) {
        player = Player(
            context, holder.surfaceFrame.width().toFloat() / 2,
            500f, 100f, 0f, 5f
        )
        background = Background(
            context, 0f,
            0f, 0f, 0f, 15f
        )
    }

    override fun update(holder: SurfaceHolder) {
        val canvas: Canvas? = holder.lockCanvas()
        background.draw(canvas)
        background.update()
        player.draw(canvas)
        holder.unlockCanvasAndPost(canvas)
    }

    override fun stop() {

    }

}