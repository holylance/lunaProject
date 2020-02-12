package com.hjcorp.lunaproject.ad

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.hjcorp.lunaproject.shared.BaseViewModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ADViewModel(
    private val context: Context
) : BaseViewModel() {
    companion object {
        private const val YOUTUBE_ID = "UCXrRClRj7noCxiBKzAPhJ6A"
    }

    var count = 0

    fun redirectToYoutube() {
        val webIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.youtube.com/channel/${YOUTUBE_ID}")
        )
        if (webIntent.resolveActivity(context.packageManager) != null)
            context.startActivity(webIntent)
    }

    fun everySeconds(): Observable<Long> {
        count = 0
        return Observable.interval(1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .doOnError {}
            .takeWhile { count <= 1 }
    }
}
