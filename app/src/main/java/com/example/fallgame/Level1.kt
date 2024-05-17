package com.example.fallgame

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.view.SurfaceHolder

class Level1(private val context: Context) : Scene() {
    override lateinit var player: Player
    override lateinit var enemy: Enemy
    override lateinit var background: Background
    private val playerSize = BitmapFactory.Options()
    private val enemySize = BitmapFactory.Options()

    init {
        playerSize.inSampleSize = 1
        enemySize.inSampleSize = 1
    }

    override fun start(holder: SurfaceHolder) {
        player = Player(
            context,
            BitmapFactory.decodeResource(context.resources, R.drawable.test_1_rockfall_player_400, playerSize),
            holder.surfaceFrame.width().toFloat() / 2,
            500f, 0f, 0f
        )
        enemy = Enemy(
            context,
            BitmapFactory.decodeResource(context.resources, R.drawable.enemy_paperplane_right_400, enemySize),
            holder.surfaceFrame.width().toFloat() / 2,
            800f, 0f, 5f
        )
        background = Background(
            context, BitmapFactory.decodeResource(
                context.resources, R.drawable.test_background
            ), 0f,
            0f, 20f, 0f)
    }

    override fun update(holder: SurfaceHolder) {
        val canvas: Canvas? = holder.lockCanvas()
        background.draw(canvas)
        background.update()
        player.draw(canvas)
        enemy.update()
        enemy.draw(canvas)
        holder.unlockCanvasAndPost(canvas)
    }

    override fun stop() {

    }

}