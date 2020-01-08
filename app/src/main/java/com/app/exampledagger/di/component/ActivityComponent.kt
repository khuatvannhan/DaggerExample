package com.app.exampledagger.di.component

import com.app.exampledagger.di.module.ApplicationModule
import dagger.Component

@Component(modules = arrayOf(ApplicationModule::class))
interface ActivityComponent
