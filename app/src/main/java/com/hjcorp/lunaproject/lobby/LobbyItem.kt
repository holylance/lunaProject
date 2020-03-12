package com.hjcorp.lunaproject.lobby

interface LobbyItem {
    val type: Type

    enum class Type(val value: Int) {
        Game(0),
        Youtube(1)
    }
}

data class GameItem(
    val gameNumber: Int,
    val gameName: String,
    override val type: LobbyItem.Type = LobbyItem.Type.Game
) : LobbyItem

data class YoutubeItem(
    override val type: LobbyItem.Type = LobbyItem.Type.Youtube
) : LobbyItem
