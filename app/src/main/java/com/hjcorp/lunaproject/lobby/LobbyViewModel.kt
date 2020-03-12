package com.hjcorp.lunaproject.lobby

import com.hjcorp.lunaproject.shared.BaseViewModel

class LobbyViewModel : BaseViewModel() {
    fun createItems(): List<LobbyItem> {
        return listOf(
            GameItem(
                gameNumber = 1,
                gameName = "Game 1"
            ),
            GameItem(
                gameNumber = 2,
                gameName = "Game 2"
            ),
            YoutubeItem()
        )
    }
}
