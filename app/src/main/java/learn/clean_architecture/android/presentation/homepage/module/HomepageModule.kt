package learn.clean_architecture.android.presentation.homepage.module

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import learn.clean_architecture.android.data.network.repository.SportDbDataStore
import learn.clean_architecture.android.data.network.repository.SportDbRepository
import learn.clean_architecture.android.data.network.services.SportDbServices
import learn.clean_architecture.android.di.scope.ActivityScope
import learn.clean_architecture.android.domain.router.ScreenRouter
import learn.clean_architecture.android.domain.router.homepage.HomepageRouter
import learn.clean_architecture.android.domain.usecase.homepage.HomepageInteractor
import learn.clean_architecture.android.domain.usecase.homepage.HomepageUseCase
import learn.clean_architecture.android.external.scheduler.AppSchedulerProvider
import learn.clean_architecture.android.presentation.homepage.contract.HomepageContract
import learn.clean_architecture.android.presentation.homepage.presenter.HomepagePresenter
import learn.clean_architecture.android.presentation.homepage.view.HomepageActivity

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
@Module
class HomepageModule {
    @Provides
    @ActivityScope
    internal fun provideActvity(homepageActivity: HomepageActivity): HomepageContract.View {
        return homepageActivity
    }

    @Provides
    @ActivityScope
    internal fun provideRouter(screenRouter: ScreenRouter, homepageActivity: HomepageActivity) =
        HomepageRouter(screenRouter, homepageActivity)

    @Provides
    @ActivityScope
    internal fun provideRepository(
        mService: SportDbServices,
        mScheduler: AppSchedulerProvider
    ): SportDbRepository = SportDbDataStore(mService, mScheduler)

    @Provides
    @ActivityScope
    internal fun provideUsecase(repository: SportDbRepository): HomepageUseCase = HomepageInteractor(repository)

    @Provides
    @ActivityScope
    internal fun providePresenter(
        view: HomepageContract.View,
        useCase: HomepageUseCase
    ) = HomepagePresenter(view, useCase)
}