package com.hjcorp.lunaproject.lobby

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.hjcorp.lunaproject.R

class LobbyItemDecorator(context: Context) : RecyclerView.ItemDecoration() {
    private val itemDivider = ContextCompat.getDrawable(context, R.drawable.lobby_divider)!!

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        when (parent.getChildViewHolder(view)) {
            is GameViewHolder,
            is YoutubeViewHolder -> {
                outRect.bottom = itemDivider.intrinsicHeight
            }
        }
    }

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        for (position in 0 until parent.childCount) {
            val childView = parent.getChildAt(position)
            val dividerTop = childView.bottom
            val dividerBottom = dividerTop + itemDivider.intrinsicHeight

            when (parent.getChildViewHolder(childView)) {
                is GameViewHolder,
                is YoutubeViewHolder -> {
                    itemDivider.setBounds(0, dividerTop, childView.right, dividerBottom)
                    itemDivider.draw(canvas)
                }
            }
        }
    }
}