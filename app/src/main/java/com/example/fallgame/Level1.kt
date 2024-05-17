package com.example.fallgame

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.view.SurfaceHolder
import kotlin.random.Random

class Level1(private val context: Context) : Scene() {
    override lateinit var player: Player
    override lateinit var enemy: Enemy
    override lateinit var background: Background
    private val playerSize = BitmapFactory.Options()
    private val enemySize = BitmapFactory.Options()
    private var side = rightSide()

    init {
        playerSize.inSampleSize = 1
        enemySize.inSampleSize = 1
    }

    override fun start(holder: SurfaceHolder) {
        player = Player(
            context,
            BitmapFactory.decodeResource(
                context.resources,
                R.drawable.test_1_rockfall_player_400,
                playerSize
            ),
            holder.surfaceFrame.width().toFloat() / 2,
            500f, 0f, 0f
        )
        enemy = Enemy(
            context,
            randomBitmap(),
            if(side) 0f else holder.surfaceFrame.width().toFloat(),
            randomHeight().toFloat(), 5f, 10f, side
        )
        background = Background(
            context, BitmapFactory.decodeResource(
                context.resources, R.drawable.test_background
            ), 0f,
            0f, 20f, 0f
        )
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

    private fun randomHeight(): Double {
        return Random.nextDouble(900.0, 1500.0)
    }

    private fun randomBitmap(): Bitmap {
        return if (side) {
            BitmapFactory.decodeResource(
                context.resources,
                R.drawable.enemy_paperplane_right_400
            )
        } else {
            BitmapFactory.decodeResource(
                context.resources,
                R.drawable.enemy_paperplane_left_400,
                enemySize
            )
        }
    }
    private fun rightSide(): Boolean {
        return Random.nextBoolean()
    }
}