package com.hjcorp.lunaproject.lobby

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hjcorp.lunaproject.R
import com.hjcorp.lunaproject.shared.BaseFragment
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.lobby_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LobbyFragment : BaseFragment() {

    private val viewModel by viewModel<LobbyViewModel>()

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

    override fun bindProperties(disposable: CompositeDisposable) {}
}
