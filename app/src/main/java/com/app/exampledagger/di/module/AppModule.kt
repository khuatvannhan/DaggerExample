package com.app.exampledagger.di.module

import dagger.Module

@Module(
    includes = [ViewModelModule::class,
        DatabaseModule::class,
        HttpModule::class,
        RxThreadModule::class]
)
class AppModule {
}
