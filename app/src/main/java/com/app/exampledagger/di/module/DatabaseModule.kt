package com.app.exampledagger.di.module

import android.app.Application
import androidx.room.Room
import com.app.exampledagger.data.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideStudentDatabase(app: Application) = Room.databaseBuilder(app,
        AppDatabase::class.java, "Students.db").build()

    @Singleton
    @Provides
    fun provideStudentDao(db: AppDatabase) = db.studentDao()

   /* @Singleton
    @Provides
    fun provideLegoSetDao(db: AppDatabase) = db.legoSetDao()*/
}
