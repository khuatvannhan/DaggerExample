package com.app.exampledagger.di.component

import com.app.exampledagger.BlankFragment
import com.app.exampledagger.MainActivity
import com.app.exampledagger.di.module.ApplicationModule
import com.app.exampledagger.di.module.DatabaseModule
import com.app.exampledagger.di.module.HttpModule
import com.app.exampledagger.di.module.RxThreadModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    ApplicationModule::class,
    DatabaseModule::class,
    HttpModule::class,
    RxThreadModule::class))
interface AppComponent {
    fun inject(fragment: BlankFragment)

    fun inject(activity: MainActivity)
}
