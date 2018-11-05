package learn.clean_architecture.android.di.module.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import learn.clean_architecture.android.di.scope.ActivityScope
import learn.clean_architecture.android.presentation.detailpage.module.DetailPageModule
import learn.clean_architecture.android.presentation.detailpage.view.DetailPageActivity
import learn.clean_architecture.android.presentation.homepage.module.HomepageModule
import learn.clean_architecture.android.presentation.homepage.view.HomepageActivity

/**
 * Created by Yoga C. Pranata on 05/11/2018.
 * Android Engineer
 */
@Module
abstract class ActivityBuilder {
    @ActivityScope
    @ContributesAndroidInjector(modules = [(HomepageModule::class)])
    internal abstract fun bindHomePageActivity(): HomepageActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(DetailPageModule::class)])
    internal abstract fun bindDetailPageActivity(): DetailPageActivity

}