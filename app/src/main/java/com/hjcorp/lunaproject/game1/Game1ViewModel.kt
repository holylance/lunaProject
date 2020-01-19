package com.hjcorp.lunaproject.game1

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import androidx.lifecycle.ViewModel
import com.hjcorp.lunaproject.R
import kotlin.random.Random


class Game1ViewModel(
    context: Context
) : ViewModel() {

    private val sounds = arrayListOf<Int>()
    private var soundPool: SoundPool? = null

    init {
        val attributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        soundPool = SoundPool.Builder()
            .setAudioAttributes(attributes)
            .build()

        soundPool?.let {soundPool ->
            sounds.add(soundPool.load(context, R.raw.dog_barking0, 0))
            sounds.add(soundPool.load(context, R.raw.dog_barking1, 0))
            sounds.add(soundPool.load(context, R.raw.dog_barking2, 0))
        }
    }

    fun playRandomDogBarking() {
        val index = Random.nextInt(0, sounds.size)
        soundPool?.play(sounds[index], 1f, 1f, 0, 0, 1f)
    }
}
