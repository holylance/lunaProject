package com.hjcorp.lunaproject.di

import com.hjcorp.lunaproject.ad.ADViewModel
import com.hjcorp.lunaproject.game0.Game0ViewModel
import com.hjcorp.lunaproject.game1.Game1ViewModel
import com.hjcorp.lunaproject.game2.Game2ViewModel
import com.hjcorp.lunaproject.lobby.LobbyViewModel
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.dsl.module
import org.threeten.bp.Clock

val appModule = module {
    factory { androidApplication().getKoin() }
    factory { Clock.systemDefaultZone() }

    viewModel<ADViewModel>()
    viewModel<Game0ViewModel>()
    viewModel<Game1ViewModel>()
    viewModel<Game2ViewModel>()
    viewModel<LobbyViewModel>()
}
