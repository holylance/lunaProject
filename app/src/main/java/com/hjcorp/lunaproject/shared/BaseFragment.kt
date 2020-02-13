package com.hjcorp.lunaproject.shared

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseFragment : Fragment() {

    companion object {
        private const val YOUTUBE_ID = "UCXrRClRj7noCxiBKzAPhJ6A"
    }

    private val compositeDisposable = CompositeDisposable()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bindProperties(compositeDisposable)
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

    abstract fun bindProperties(disposable: CompositeDisposable)

    protected fun bind(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    protected fun redirectToYoutube() {
        val webIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.youtube.com/channel/${YOUTUBE_ID}")
        )
        context?.let { context ->
            if (webIntent.resolveActivity(context.packageManager) != null)
                context.startActivity(webIntent)
        }
    }
}
