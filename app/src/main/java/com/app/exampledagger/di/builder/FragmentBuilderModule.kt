package com.app.exampledagger.di.builder

import com.app.exampledagger.BlankFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * This builder provides android injector service to fragments
 */
@Module
abstract class FragmentBuilderModule {
//    @SuppressWarnings("unused")
//    @ContributesAndroidInjector
//    abstract fun contributeArticleListFragment(): ArticleListFragment?
//
    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract fun contributeFragment(): BlankFragment
}
