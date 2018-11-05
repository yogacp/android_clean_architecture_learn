package learn.clean_architecture.android.presentation.detailpage.module

import dagger.Module
import dagger.Provides
import learn.clean_architecture.android.di.scope.ActivityScope
import learn.clean_architecture.android.presentation.detailpage.contract.DetailPageContract
import learn.clean_architecture.android.presentation.detailpage.presenter.DetailPagePresenter
import learn.clean_architecture.android.presentation.detailpage.view.DetailPageActivity

/**
 * Created by Yoga C. Pranata on 05/11/2018.
 * Android Engineer
 */
@Module
class DetailPageModule {

    @Provides
    @ActivityScope
    internal fun provideActvity(detailPageActivity: DetailPageActivity): DetailPageContract.View {
        return detailPageActivity
    }

    @Provides
    @ActivityScope
    internal fun providePresenter(view: DetailPageContract.View) = DetailPagePresenter(view)
}