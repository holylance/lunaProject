package com.hjcorp.lunaproject.lobby

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hjcorp.lunaproject.R

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LobbyViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
