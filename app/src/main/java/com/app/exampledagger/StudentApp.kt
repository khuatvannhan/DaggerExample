package com.app.exampledagger

import android.app.Activity
import android.app.Application
import com.app.exampledagger.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * File Description
 * <p>
 */
class StudentApp : Application(), HasActivityInjector {
    @Inject
    @JvmField
    var activityDispatchingInjector: DispatchingAndroidInjector<Activity>? = null

    override fun onCreate() {
        super.onCreate()
        initializeComponent()
        setInstance(this)
    }

    private fun initializeComponent() {
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity>? {
        return activityDispatchingInjector
    }

    companion object {
        var appContext: StudentApp? = null
            private set

        @Synchronized
        private fun setInstance(app: StudentApp) {
            appContext = app
        }
    }
}

