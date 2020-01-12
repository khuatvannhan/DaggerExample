package com.app.exampledagger.di.module

import com.app.exampledagger.api.ApiInterface
import com.app.exampledagger.api.AuthInterceptor
import com.app.exampledagger.student.data.ApiConstants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * The application module which provides app wide instances of various components
 */
@Module
class HttpModule {
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.connectTimeout(
            ApiConstants.CONNECT_TIMEOUT,
            TimeUnit.MILLISECONDS
        )
        okHttpClient.readTimeout(
            ApiConstants.READ_TIMEOUT,
            TimeUnit.MILLISECONDS
        )
        okHttpClient.writeTimeout(
            ApiConstants.WRITE_TIMEOUT,
            TimeUnit.MILLISECONDS
        )
        okHttpClient.addInterceptor(AuthInterceptor("accessToken"))
        okHttpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return okHttpClient.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): ApiInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit.create<ApiInterface>(ApiInterface::class.java)
    }
}
