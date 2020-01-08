package com.app.exampledagger.di.module

import android.app.Application
import com.app.exampledagger.data.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDb(app: Application) = AppDatabase.getInstance(app)

    @Singleton
    @Provides
    fun provideStudentDao(db: AppDatabase) = db.studentDao()

   /* @Singleton
    @Provides
    fun provideLegoSetDao(db: AppDatabase) = db.legoSetDao()*/
}
