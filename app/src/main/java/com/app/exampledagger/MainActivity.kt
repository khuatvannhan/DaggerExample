package com.app.exampledagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.app.exampledagger.student.StudentFragment
import com.app.exampledagger.util.FragmentUtils
import com.app.exampledagger.util.FragmentUtils.TRANSITION_NONE
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var fragmentAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FragmentUtils.replaceFragment(
            this,
            StudentFragment.newInstance(),
            R.id.fragContainer,
            false,
            TRANSITION_NONE
        )
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentAndroidInjector
}
