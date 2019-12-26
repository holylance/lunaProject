package com.hjcorp.lunaproject.game1

import android.graphics.drawable.AnimationDrawable
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hjcorp.lunaproject.R
import kotlinx.android.synthetic.main.game1_fragment.*

class Game1Fragment : Fragment() {

    companion object {
        fun newInstance() = Game1Fragment()
    }

    private lateinit var viewModel: Game1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.game1_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        game1_sprite.setImageResource(R.drawable.battery_sprite)
        game1_sprite.setOnClickListener {
            runSprite()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(Game1ViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun runSprite() {
        val sprite = game1_sprite.drawable as AnimationDrawable
        sprite.stop()
        sprite.start()
    }
}
