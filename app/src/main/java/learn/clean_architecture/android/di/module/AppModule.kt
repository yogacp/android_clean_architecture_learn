package learn.clean_architecture.android.di.module

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import learn.clean_architecture.android.di.scope.AppScope
import learn.clean_architecture.android.domain.router.ScreenRouter
import learn.clean_architecture.android.domain.router.ScreenRouterImpl
import learn.clean_architecture.android.external.helper.Helper
import learn.clean_architecture.android.external.scheduler.AppSchedulerProvider

/**
 * Created by Yoga C. Pranata on 05/11/2018.
 * Android Engineer
 */
@Module
class AppModule {

    @Provides
    @AppScope
    fun provideScreenRouter(): ScreenRouter = ScreenRouterImpl()

    @Provides
    @AppScope
    fun context(application: Application): Context = application

    @Provides
    @AppScope
    fun gson() = Gson()

    @Provides
    @AppScope
    fun helper() = Helper()

    @Provides
    @AppScope
    fun provideSchedulerProvider() = AppSchedulerProvider()

    @Provides
    @AppScope
    fun provideCompositeDisposable() = CompositeDisposable()
}