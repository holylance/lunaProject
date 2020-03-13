package com.hjcorp.lunaproject.game1

import android.content.Context
import com.hjcorp.lunaproject.R
import com.hjcorp.lunaproject.shared.BaseViewModel

class Game1ViewModel(
    context: Context
) : BaseViewModel() {

    var imageResource: Int = 0
    val soundsAirIntoBalloon = arrayListOf<Int>()
    val soundsPang = arrayListOf<Int>()

    init {
        imageResource = 0

        soundPool?.let { soundPool ->
            soundsAirIntoBalloon.add(soundPool.load(context, R.raw.air_into_balloon0, 0))
            soundsAirIntoBalloon.add(soundPool.load(context, R.raw.air_into_balloon1, 0))
            soundsAirIntoBalloon.add(soundPool.load(context, R.raw.air_into_balloon2, 0))

            soundsPang.add(soundPool.load(context, R.raw.balloon_pang0, 0))
            soundsPang.add(soundPool.load(context, R.raw.balloon_pang1, 0))
            soundsPang.add(soundPool.load(context, R.raw.balloon_pang2, 0))
            soundsPang.add(soundPool.load(context, R.raw.balloon_pang3, 0))
        }
    }
}
