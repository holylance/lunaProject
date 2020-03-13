package com.hjcorp.lunaproject.game0

import android.content.Context
import com.hjcorp.lunaproject.R
import com.hjcorp.lunaproject.shared.BaseViewModel

class Game0ViewModel(
    context: Context
) : BaseViewModel() {

    val sounds = arrayListOf<Int>()

    init {
        soundPool?.let { soundPool ->
            sounds.add(soundPool.load(context, R.raw.dog_barking0, 0))
            sounds.add(soundPool.load(context, R.raw.dog_barking1, 0))
            sounds.add(soundPool.load(context, R.raw.dog_barking2, 0))
        }
    }
}
