package id.sardjito.fastmed.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import id.sardjito.fastmed.network.FastMedService
import id.sardjito.fastmed.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [OkHttpClientModule::class])
class RetrofitModule {
    @Provides @Singleton
    fun provideApi(retrofit: Retrofit) : FastMedService {
        return retrofit.create(FastMedService::class.java)
    }

    @Provides @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides @Singleton
    fun provideGson() : Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides @Singleton
    fun provideGsonConverterFactory(gson: Gson) : GsonConverterFactory = GsonConverterFactory.create(gson)
}