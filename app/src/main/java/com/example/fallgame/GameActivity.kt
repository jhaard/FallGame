package com.example.fallgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageButton
import com.example.fallgame.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private lateinit var gameView: GameView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gameView = GameView(this)

        val frameLayoutContainer: FrameLayout = binding.root.findViewById(R.id.sv_frame)
        frameLayoutContainer.addView(gameView)

        val slowButton: ImageButton = binding.btnSlow
        val flashButton: ImageButton = binding.btnFlash
        gameView.onSlowButtonTouch(slowButton)
        gameView.onFlashButtonTouch(flashButton)
    }

    override fun onDestroy() {
        super.onDestroy()
        gameView.stop()

    }

    override fun onPause() {
        super.onPause()
        gameView.stop()
    }
}