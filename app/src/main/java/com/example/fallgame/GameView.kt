package com.example.fallgame

import android.content.Context
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.ImageButton
import java.util.Timer
import java.util.TimerTask

class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback, Runnable {
    private val scene: SceneManager = SceneManager(holder)
    private val level: Level1 = Level1(context)
    private val gameHolder: SurfaceHolder? = holder
    private var thread: Thread? = null
    private var running = false
    private var timer: Timer? = null

    init {
        gameHolder?.addCallback(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        scene.loadScene(level)
        start()
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        stop()
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        level.player.posX = event!!.x
        if (event.x > width/2) {
            println("Bigger than half the screen")
        }

        return true
    }
    fun onSlowButtonTouch(slowButton: ImageButton) {
        slowButton.setOnClickListener {
            if (timer != null) {
                timer?.cancel()
                timer = null
            }
            timer = Timer()
            timer?.schedule(object : TimerTask() {
                override fun run() {
                    level.background.vGravity = 2f
                }
            }, 0, 1000)
            Thread.sleep(2000)
            timer?.cancel()
            level.background.vGravity = 10f
        }
    }
    fun onFlashButtonTouch(flashButton: ImageButton) {
        flashButton.setOnClickListener {
            if (timer != null) {
                timer?.cancel()
                timer = null
            }
            timer = Timer()
            timer?.schedule(object : TimerTask() {
                override fun run() {
                    level.background.vGravity = 25f
                }
            }, 0, 1000)
            Thread.sleep(2000)
            timer?.cancel()
            level.background.vGravity = 10f
        }
    }
    private fun start() {
        running = true
        thread = Thread(this)
        thread?.start()
    }

    fun stop() {
        running = false
        try {
            thread?.interrupt()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    override fun run() {
        while (running) {
            level.update(gameHolder!!)
        }
    }
}