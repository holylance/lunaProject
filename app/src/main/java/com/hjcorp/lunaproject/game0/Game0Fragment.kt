package com.hjcorp.lunaproject.game0

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hjcorp.lunaproject.R
import com.hjcorp.lunaproject.shared.BaseFragment
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.game0_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class Game0Fragment : BaseFragment() {

    private val viewModel by viewModel<Game0ViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.game0_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        game0_sprite.setImageResource(R.drawable.battery_sprite)
        game0_sprite.setOnClickListener {
            runSprite()
        }
    }

    override fun bindProperties(disposable: CompositeDisposable) {}

    private fun runSprite() {
        val sprite = game0_sprite.drawable as AnimationDrawable
        sprite.stop()
        viewModel.playRandomSound(viewModel.sounds)
        sprite.start()
    }
}
