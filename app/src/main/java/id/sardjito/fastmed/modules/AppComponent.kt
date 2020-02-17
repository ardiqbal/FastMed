package id.sardjito.fastmed.modules

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    RetrofitModule::class,
    ViewModelModule::class,
    ActivityFragmentModule::class])
interface AppComponent : AndroidInjector<DaggerApplication>{    
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: DaggerApplication?)
}

