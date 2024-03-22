package com.example.fallgame

import android.view.SurfaceHolder


class SceneManager(private val holder: SurfaceHolder) {

    private var currentScene: Scene? = null

    fun loadScene(scene: Scene) {
        currentScene?.stop()
        currentScene = null

        currentScene = scene
        currentScene?.start(holder)
    }
}