package learn.clean_architecture.android.koin

import learn.clean_architecture.android.data.network.repository.SportDbDataStore
import learn.clean_architecture.android.data.network.repository.SportDbRepository
import learn.clean_architecture.android.domain.router.ScreenRouter
import learn.clean_architecture.android.domain.router.ScreenRouterImpl
import org.koin.dsl.module.module

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
val appModule = module {
    networkModule
    single<ScreenRouter> { ScreenRouterImpl() }
    single<SportDbRepository> { SportDbDataStore(get(), get()) }
}