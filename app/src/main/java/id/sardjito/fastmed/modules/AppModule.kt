package id.sardjito.fastmed.modules

import android.app.Application
import dagger.Binds
import dagger.Module
import id.sardjito.fastmed.App

@Module
abstract class AppModule {

    @Binds
    abstract fun application (app : App): Application
}