package com.hjcorp.lunaproject.game2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.hjcorp.lunaproject.R
import kotlinx.android.synthetic.main.game2_fragment.*

class Game2Fragment : Fragment() {

    companion object {
        fun newInstance() = Game2Fragment()
    }

    private lateinit var viewModel: Game2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = Game2ViewModel()
        return inflater.inflate(R.layout.game2_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setImage(R.drawable.ic_filter_1_black_24dp)

        setExitListener(game2_layout)
        setExitListener(game2_sprite)

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

    private fun setImage(resourceId: Int) {
        game2_sprite.setImageResource(resourceId)
        viewModel.imageResource = resourceId
    }

    private fun setExitListener(view: View) {
        view.apply {
            setOnLongClickListener {
                exit_progress_bar.visibility = View.VISIBLE
                game2_exit_textView.visibility = View.VISIBLE
                false
            }

            setOnTouchListener { _, event ->
                when(event.action) {
                    MotionEvent.ACTION_UP -> {
                        exit_progress_bar.visibility = View.GONE
                        game2_exit_textView.visibility = View.GONE
                        false
                    }
                    else -> {
                        false
                    }
                }
            }
        }
    }
}
