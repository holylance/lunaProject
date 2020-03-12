package com.hjcorp.lunaproject.lobby

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hjcorp.lunaproject.R
import com.hjcorp.lunaproject.lobby.LobbyItem.Type

class LobbyAdapter(
    private val listener : OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val items: MutableList<LobbyItem> = emptyList<LobbyItem>().toMutableList()

    override fun getItemViewType(position: Int): Int {
        return items[position].type.value
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            Type.Game.value -> GameViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.game_item, parent, false))
            else -> YoutubeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.youtube_item, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is GameViewHolder -> holder.bind(items[position] as GameItem, listener)
            is YoutubeViewHolder -> holder.bind(items[position] as YoutubeItem, listener)
            else -> error("Invalid view type")
        }
    }

    fun setItems(newItems: List<LobbyItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    interface OnItemClickListener {
        fun onItemClick(data: LobbyItem)
    }
}
