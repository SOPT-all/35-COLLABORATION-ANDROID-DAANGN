package org.sopt.carrot

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import timber.log.Timber

class DaggnApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
        disableDarkMode()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    private fun disableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}
