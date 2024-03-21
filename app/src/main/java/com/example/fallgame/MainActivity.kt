package com.example.fallgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fallgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isHighscoreShowing = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlay.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

        binding.btnHighscore.setOnClickListener {

            isHighscoreShowing = !isHighscoreShowing
            val fragment = supportFragmentManager.beginTransaction()

            if (isHighscoreShowing) {
                fragment.replace(R.id.highscore_container, HighscoreFragment())
                fragment.addToBackStack(null)
                fragment.commit()
            } else if (!isHighscoreShowing) {
                supportFragmentManager.popBackStack()
            }
        }
    }
}