package com.app.exampledagger.di.component

import android.app.Application
import com.app.exampledagger.di.module.DatabaseModule
import com.app.exampledagger.di.module.HttpModule
import com.app.exampledagger.di.module.RxThreadModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class, HttpModule::class, RxThreadModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application?): Builder?

        fun build(): AppComponent?
    }

//    fun inject(nyTimesApp: NYTimesApp?)
}
