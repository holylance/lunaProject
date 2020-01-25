package com.hjcorp.lunaproject.ad

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Handler
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.hjcorp.lunaproject.R
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class ADViewModel(
    private val context: Context,
    private val progressBar_youtube: ProgressBar
) : ViewModel() {
    companion object {
        private const val YOUTUBE_ID = "UCXrRClRj7noCxiBKzAPhJ6A"
    }

    val disposable: Disposable
    private var count = 0

    init {
        disposable = everySeconds()
    }

    fun redirectToYoutube() {
        val webIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.youtube.com/channel/${YOUTUBE_ID}")
        )
        if (webIntent.resolveActivity(context.packageManager) != null)
            context.startActivity(webIntent)
    }

    fun delayNav(nav_host: Fragment) {
        Handler().postDelayed(
            {
                nav_host.findNavController().navigate(R.id.lobbyFragment)
            }
            ,2000
        )
    }

    private fun everySeconds(): Disposable {
        count = 0
        return Observable.interval(1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .doOnNext {
                count++
                progressBar_youtube.progress = count * 50
                if (count > 2)
                    disposable.dispose()
            }
            .doOnComplete {}
            .doOnError {}
            .subscribe()
    }
}
