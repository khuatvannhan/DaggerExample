package com.app.exampledagger.di.module

import android.app.Application
import androidx.room.Room
import com.app.exampledagger.api.ApiInterface
import com.app.exampledagger.api.AuthInterceptor
import com.app.exampledagger.data.AppDatabase
import com.app.exampledagger.student.data.ApiConstants
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModel {

    @Singleton
    @Provides
    fun provideStudentDatabase(app: Application) = Room.databaseBuilder(app,
        AppDatabase::class.java, "Students.db").build()

    @Singleton
    @Provides
    fun provideStudentDao(db: AppDatabase) = db.studentDao()

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

    companion object {
        const val mainThread = "mainThread"
        const val ioThread = "ioThread"
    }

    @Singleton
    @Provides
    @Named(mainThread)
    open fun provideAndroidSchedulers(): Scheduler = AndroidSchedulers.mainThread()

    @Singleton
    @Provides
    @Named(ioThread)
    open fun provideSchedulersIO(): Scheduler = Schedulers.io()
}
