package com.hjcorp.lunaproject.game2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hjcorp.lunaproject.R
import com.hjcorp.lunaproject.shared.BaseFragment
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.game2_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class Game2Fragment : BaseFragment() {

    private val viewModel by viewModel<Game2ViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.game2_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setImage(R.drawable.ic_filter_1_black_24dp)

        game2_sprite.apply {
            setOnClickListener {
                when(viewModel.imageResource) {
                    R.drawable.ic_filter_1_black_24dp -> {
                        setImage(R.drawable.ic_filter_2_black_24dp)
                    }
                    R.drawable.ic_filter_2_black_24dp -> {
                        setImage(R.drawable.ic_filter_3_black_24dp)
                    }
                    R.drawable.ic_filter_3_black_24dp -> {
                        setImage(R.drawable.ic_filter_4_black_24dp)
                    }
                    R.drawable.ic_filter_4_black_24dp -> {
                        setImage(R.drawable.ic_filter_5_black_24dp)
                    }
                    else -> {
                        setImage(R.drawable.ic_filter_1_black_24dp)
                    }
                }
            }
        }
    }

    override fun bindProperties(disposable: CompositeDisposable) {}

    private fun setImage(resourceId: Int) {
        game2_sprite.setImageResource(resourceId)
        viewModel.imageResource = resourceId
    }
}
