package com.hjcorp.lunaproject.lobby

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hjcorp.lunaproject.R
import com.hjcorp.lunaproject.shared.BaseFragment
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.lobby_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.hjcorp.lunaproject.lobby.LobbyItem.Type

class LobbyFragment : BaseFragment() {

    private val viewModel by viewModel<LobbyViewModel>()
    private val lobbyAdapter = LobbyAdapter(ItemClickListener())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lobby_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lobbyAdapter.setItems(viewModel.createItems())

        game_items_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lobbyAdapter

            addItemDecoration(LobbyItemDecorator(context))
        }
    }

    inner class ItemClickListener : LobbyAdapter.OnItemClickListener {
        override fun onItemClick(data: LobbyItem) {
            when (data.type) {
                Type.Game -> {
                    data as GameItem
                    when(data.gameNumber) {
                        0 -> nav_host.findNavController().navigate(R.id.action_lobbyFragment_to_game0Fragment)
                        1 -> nav_host.findNavController().navigate(R.id.action_lobbyFragment_to_game1Fragment)
                        else -> nav_host.findNavController().navigate(R.id.action_lobbyFragment_to_game2Fragment)
                    }
                }
                Type.Youtube -> {
                    redirectToYoutube()
                }
            }
        }
    }

    override fun bindProperties(disposable: CompositeDisposable) {}
}
