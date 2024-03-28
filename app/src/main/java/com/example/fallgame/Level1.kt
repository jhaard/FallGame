package com.example.fallgame

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.view.SurfaceHolder

open class Level1(private val context: Context) : Scene() {
    lateinit var player: Player
    lateinit var background: Background
    private val playerSize = BitmapFactory.Options()

    init {
        playerSize.inSampleSize = 1
    }

    override fun start(holder: SurfaceHolder) {
        player = Player(
            context,
            BitmapFactory.decodeResource(context.resources, R.drawable.test_1_rockfall_player_400, playerSize),
            holder.surfaceFrame.width().toFloat() / 2,
            500f, 15f
        )
        background = Background(
            context, BitmapFactory.decodeResource(
                context.resources, R.drawable.test_background
            ), 0f,
            0f, 15f)
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