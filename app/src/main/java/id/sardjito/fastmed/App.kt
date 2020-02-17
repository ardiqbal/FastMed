package id.sardjito.fastmed

import android.app.Application
import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import id.sardjito.fastmed.modules.DaggerAppComponent
import id.sardjito.fastmed.utils.Constants
import timber.log.Timber

class App : DaggerApplication(){

    private val appComponent = DaggerAppComponent.builder()
        .application(this)
        .build()

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)

        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }
}