package com.hjcorp.lunaproject.lobby

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.hjcorp.lunaproject.R

class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: GameItem, listener: LobbyAdapter.OnItemClickListener) {
        itemView.findViewById<ImageView>(R.id.game_item_icon).apply {
            setImageResource(R.drawable.ic_filter_1_black_24dp)
        }

        itemView.findViewById<AppCompatTextView>(R.id.game_item_title).apply {
            text = item.gameName
        }

        itemView.findViewById<AppCompatTextView>(R.id.game_item_subtitle).apply {
            text = item.gameNumber.toString()
        }

        itemView.setOnClickListener {
            listener.onItemClick(item)
        }
    }
}

class YoutubeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: YoutubeItem, listener: LobbyAdapter.OnItemClickListener) {
        itemView.setOnClickListener {
            listener.onItemClick(item)
        }
    }
}
