package com.hjcorp.lunaproject.lobby

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.hjcorp.lunaproject.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.lobby_fragment.*

class LobbyFragment : Fragment() {

    companion object {
        fun newInstance() = LobbyFragment()
    }

    private lateinit var viewModel: LobbyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lobby_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_game1.setOnClickListener {
            nav_host.findNavController().navigate(R.id.action_lobbyFragment_to_game1Fragment)
        }
        button_game2.setOnClickListener {
            nav_host.findNavController().navigate(R.id.action_lobbyFragment_to_game2Fragment)
        }
        button_youtube.setOnClickListener {
            viewModel.redirectToYoutube()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = LobbyViewModel(context!!)
    }
}
