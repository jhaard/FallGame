package com.example.fallgame

import android.view.SurfaceHolder

abstract class Scene {
    abstract fun start(holder: SurfaceHolder)

    abstract fun update(holder: SurfaceHolder)

    abstract fun stop()
}