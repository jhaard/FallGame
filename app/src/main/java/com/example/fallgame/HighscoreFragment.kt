package com.example.fallgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fallgame.databinding.FragmentHighscoreBinding


class HighscoreFragment : Fragment() {
    private lateinit var binding: FragmentHighscoreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHighscoreBinding.inflate(layoutInflater)

        return binding.root
    }


}