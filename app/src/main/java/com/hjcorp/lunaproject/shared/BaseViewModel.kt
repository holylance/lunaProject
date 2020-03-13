package com.hjcorp.lunaproject.shared

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlin.random.Random

abstract class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    protected var soundPool: SoundPool? = null

    init {
        soundPool = SoundPool.Builder()
            .setAudioAttributes(buildAudioAttributes())
            .build()
    }

    protected fun bind(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    private fun buildAudioAttributes(): AudioAttributes {
        return AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
    }

    fun playRandomSound(sounds: ArrayList<Int>) {
        val index = Random.nextInt(0, sounds.size)
        soundPool?.play(sounds[index], 1f, 1f, 0, 0, 1f)
    }
}
