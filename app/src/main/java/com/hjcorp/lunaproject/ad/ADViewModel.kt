package com.hjcorp.lunaproject.ad

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel

class ADViewModel(
    private val context: Context
) : ViewModel() {
    companion object {
        private const val YOUTUBE_ID = "UCXrRClRj7noCxiBKzAPhJ6A"
    }

    fun redirectToYoutube() {
        val webIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.youtube.com/channel/${YOUTUBE_ID}")
        )
        if (webIntent.resolveActivity(context.packageManager) != null)
            context.startActivity(webIntent)
    }
}
