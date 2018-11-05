package learn.clean_architecture.android.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import learn.clean_architecture.android.MainApp
import learn.clean_architecture.android.di.module.AppModule
import learn.clean_architecture.android.di.module.NetworkModule
import learn.clean_architecture.android.di.module.builder.ActivityBuilder
import learn.clean_architecture.android.di.scope.AppScope

/**
 * Created by Yoga C. Pranata on 05/11/2018.
 * Android Engineer
 */
@AppScope
@Component(
    modules = [
        (AndroidInjectionModule::class),
        (AppModule::class),
        (NetworkModule::class),
        (ActivityBuilder::class)
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun networkModule(networkModule: NetworkModule): Builder
        fun build(): AppComponent
    }

    fun inject(app: MainApp)
}