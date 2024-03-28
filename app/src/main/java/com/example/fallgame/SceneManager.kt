package com.example.fallgame

import android.view.SurfaceHolder

class SceneManager(private val holder: SurfaceHolder) {
    private var currentScene: Int = 0
    fun loadScene(sceneList: List<Scene>): Scene {
        var scene: Scene? = null
        if (scene == null) {
            scene = sceneList[currentScene]
            scene.start(holder)
        } else {
            scene.stop()
        }
        return sceneList[currentScene]
    }

    fun loadNextScene(newScene: Int) {
        this.currentScene = newScene
    }
}