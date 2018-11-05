package learn.clean_architecture.android

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import learn.clean_architecture.android.di.component.AppComponent
import learn.clean_architecture.android.di.component.DaggerAppComponent
import learn.clean_architecture.android.di.module.NetworkModule
import javax.inject.Inject

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
class MainApp : Application(), HasActivityInjector {

    companion object {
        @JvmStatic
        lateinit var instance: MainApp
        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = createComponent()
        appComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    /**
     * Initialize Dependency Injection With Dagger
     * Level DI Application
     * */
    private fun createComponent(): AppComponent {
        return DaggerAppComponent.builder()
            .application(this)
            .networkModule(NetworkModule(this))
            .build()
    }

}