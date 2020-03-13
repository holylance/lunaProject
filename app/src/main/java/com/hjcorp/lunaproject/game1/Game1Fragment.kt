package com.hjcorp.lunaproject.game1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hjcorp.lunaproject.R
import com.hjcorp.lunaproject.shared.BaseFragment
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.game1_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class Game1Fragment : BaseFragment() {

    private val viewModel by viewModel<Game1ViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.game1_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setImage(R.drawable.ic_filter_1_black_24dp)

        game1_sprite.apply {
            setOnClickListener {
                when(viewModel.imageResource) {
                    R.drawable.ic_filter_1_black_24dp -> {
                        setImage(R.drawable.ic_filter_2_black_24dp)
                        viewModel.playRandomSound(viewModel.soundsAirIntoBalloon)
                    }
                    R.drawable.ic_filter_2_black_24dp -> {
                        setImage(R.drawable.ic_filter_3_black_24dp)
                        viewModel.playRandomSound(viewModel.soundsAirIntoBalloon)
                    }
                    R.drawable.ic_filter_3_black_24dp -> {
                        setImage(R.drawable.ic_filter_4_black_24dp)
                        viewModel.playRandomSound(viewModel.soundsAirIntoBalloon)
                    }
                    R.drawable.ic_filter_4_black_24dp -> {
                        setImage(R.drawable.ic_filter_5_black_24dp)
                        viewModel.playRandomSound(viewModel.soundsAirIntoBalloon)
                    }
                    else -> {
                        setImage(R.drawable.ic_filter_1_black_24dp)
                        viewModel.playRandomSound(viewModel.soundsPang)
                    }
                }
            }
        }
    }

    override fun bindProperties(disposable: CompositeDisposable) {}

    private fun setImage(resourceId: Int) {
        game1_sprite.setImageResource(resourceId)
        viewModel.imageResource = resourceId
    }
}
