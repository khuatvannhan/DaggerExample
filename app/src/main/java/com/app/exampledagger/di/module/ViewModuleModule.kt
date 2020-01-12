package com.app.exampledagger.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.exampledagger.MainViewModel
import com.app.exampledagger.student.data.StudentsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Alloes us to inject dependencies via constructor injection
 * <p>
 */
@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel


    @Binds
    @SuppressWarnings("unused")
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
    //Add more ViewModels here
}
