package com.hjcorp.lunaproject.ad

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
        image_button_youtube.setOnClickListener {
            viewModel.redirectToYoutube()
        }

        delayNav()
    }

    override fun onResume() {
        super.onResume()
        delayNav()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ADViewModel(context!!)
    }

    private fun delayNav() {
        Handler().postDelayed(
            {
                nav_host.findNavController().navigate(R.id.lobbyFragment)
            }
            ,2000
        )
    }
}
