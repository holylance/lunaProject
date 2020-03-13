package com.hjcorp.lunaproject.game2

import android.content.Context
import com.hjcorp.lunaproject.R
import com.hjcorp.lunaproject.shared.BaseViewModel

class Game2ViewModel(
    context: Context
) : BaseViewModel() {

    var imageResource: Int = 0
    val soundsBoxCrashing = arrayListOf<Int>()

    init {
        imageResource = 0

        soundPool?.let { soundPool ->
            soundsBoxCrashing.add(soundPool.load(context, R.raw.box_crashing0, 0))
            soundsBoxCrashing.add(soundPool.load(context, R.raw.box_crashing1, 0))
            soundsBoxCrashing.add(soundPool.load(context, R.raw.box_crashing2, 0))
        }
    }
}
