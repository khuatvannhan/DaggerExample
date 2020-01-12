package com.app.exampledagger.di.builder

import com.app.exampledagger.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * The module which provides the android injection service to Activities.
 */
@Suppress("unused")
@Module
abstract class ActivityBuilderModule {
    @SuppressWarnings("unused")
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun mainActivity(): MainActivity
}
