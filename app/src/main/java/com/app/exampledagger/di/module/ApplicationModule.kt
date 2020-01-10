//package com.app.exampledagger.di.module
//
//import android.content.Context
//import androidx.room.Room
//import com.app.exampledagger.student.data.DefaultStudentsRepository
//import com.app.exampledagger.student.data.StudentsDataSource
//import com.app.exampledagger.data.AppDatabase
//import com.app.exampledagger.student.data.remote.StudentsRemoteDataSource
//import dagger.Binds
//import dagger.Module
//import dagger.Provides
//import kotlinx.coroutines.Dispatchers
//import javax.inject.Qualifier
//import javax.inject.Singleton
//
//@Module(includes = [ApplicationModuleBinds::class])
//object ApplicationModule {
//    @Qualifier
//    @Retention(AnnotationRetention.RUNTIME)
//    annotation class StudentsRemoteDataSource
//
//    @Qualifier
//    @Retention(AnnotationRetention.RUNTIME)
//    annotation class StudentsLocalDataSource
//
//    @JvmStatic
//    @Singleton
//    @StudentsRemoteDataSource
//    @Provides
//    fun provideStudentsRemoteDataSource(): StudentsDataSource {
//        return StudentsRemoteDataSource
//    }
//
//    @JvmStatic
//    @Singleton
//    @Provides
//    fun provideIoDispatcher() = Dispatchers.IO
//}
//
//@Module
//abstract class ApplicationModuleBinds {
//    @Singleton
//    @Binds
//    abstract fun bindRespository(repo: DefaultStudentsRepository)
//}
