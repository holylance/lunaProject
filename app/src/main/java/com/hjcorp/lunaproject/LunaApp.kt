package com.hjcorp.lunaproject

import android.app.Application
import com.hjcorp.lunaproject.di.appModule
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import timber.log.Timber

open class LunaApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()
        initTimber()
        initThreeTenTime()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@LunaApp)
            modules(koinModules())
        }
    }

    protected open fun koinModules(): List<Module> {
        return listOf(appModule)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initThreeTenTime() {
        AndroidThreeTen.init(this)
    }
}
