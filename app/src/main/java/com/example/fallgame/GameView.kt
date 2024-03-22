package com.example.fallgame

import android.content.Context
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback, Runnable {
    private val scene: SceneManager = SceneManager(holder)
    private val level: Level1 = Level1(context)

    private var thread: Thread? = null
    private var running = false


    init {
        if (holder != null) {
            holder?.addCallback(this)
        }
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        scene.loadScene(level)
        level.start(holder)
        start()

    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        level.draw(holder)
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        stop()
    }

    private fun update() {
        level.update()
    }

    private fun start() {
        running = true
        thread = Thread(this)
        thread?.start()
    }

    private fun stop() {
        running = false
        try {
            thread?.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    override fun run() {
        while (running) {
            update()
            //Must draw in thread to update position
        }
    }
}