package com.hjcorp.lunaproject.ad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hjcorp.lunaproject.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ad_fragment.*

class ADFragment : Fragment() {
    companion object {
        fun newInstance() = ADFragment()
    }

    private lateinit var viewModel: ADViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ad_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ADViewModel(context!!, progress_bar_youtube)

        image_button_youtube.setOnClickListener {
            viewModel.redirectToYoutube()
        }

        viewModel.delayNav(nav_host)
    }

    override fun onResume() {
        super.onResume()
        viewModel.delayNav(nav_host)
    }

    override fun onDestroy() {
        viewModel.disposable.dispose()
        super.onDestroy()
    }
}
