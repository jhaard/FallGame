package com.example.fallgame

import android.content.Context
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.ImageButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback, Runnable {
    private val scene: SceneManager = SceneManager(holder)
    private val levelList: List<Scene> = mutableListOf(Level1(context))
    private val nextLevel: Int = 0
    private val gameHolder: SurfaceHolder? = holder
    private var thread: Thread? = null
    private var running = false

    init {
        scene.loadNextScene(nextLevel)
        gameHolder?.addCallback(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        scene.loadScene(levelList)
        start()
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        stop()
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val offset = 200
        val leftX = levelList[nextLevel].player.posX - offset
        val rightX = levelList[nextLevel].player.posX + offset
        if(event!!.x > leftX && event!!.x < rightX) {
            levelList[nextLevel].player.posX = event.x
        }
        return true
    }
    fun onSlowButtonTouch(slowButton: ImageButton) {
        slowButton.setOnClickListener {
            slowButton.isEnabled = false
            GlobalScope.launch(Dispatchers.Main) {
                levelList[nextLevel].background.vGravity = 2f
                delay(2000)
                slowButton.isEnabled = true
                levelList[nextLevel].background.vGravity = 15f
            }
        }
    }
    fun onFlashButtonTouch(flashButton: ImageButton) {
        flashButton.setOnClickListener {
            flashButton.isEnabled = false
            GlobalScope.launch(Dispatchers.Main) {
                levelList[nextLevel].background.vGravity = 120f
                delay(80)
                flashButton.isEnabled = true
                levelList[nextLevel].background.vGravity = 15f
            }
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
            levelList[nextLevel].update(gameHolder!!)
        }
    }
}