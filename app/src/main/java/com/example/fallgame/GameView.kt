package com.example.fallgame

import android.content.Context
import android.view.SurfaceHolder
import android.view.SurfaceView

class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback, Runnable {
    private val scene: SceneManager = SceneManager(holder)
    private val level: Level1 = Level1(context)


    init {
        if (holder !=null) {
            holder?.addCallback(this)
        }
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        scene.loadScene(level)
        level.start(holder)


    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        level.update(holder)
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {

    }

    override fun run() {

    }
}