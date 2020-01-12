package com.app.exampledagger.di.component

import android.app.Application
import com.app.exampledagger.StudentApp
import com.app.exampledagger.di.builder.ActivityBuilderModule
import com.app.exampledagger.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: StudentApp)
}
