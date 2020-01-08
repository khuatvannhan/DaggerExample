package com.app.exampledagger

import android.app.Application
import com.app.exampledagger.di.component.AppComponent
import com.app.exampledagger.di.module.ApplicationModule
import com.app.exampledagger.di.module.HttpModule

open class MainApplication : Application() {
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        createComponent()
    }

    private fun createComponent() {
        component = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule::provideDataBase)
            .httpModule(HttpModule())
            .build()
    }
}
