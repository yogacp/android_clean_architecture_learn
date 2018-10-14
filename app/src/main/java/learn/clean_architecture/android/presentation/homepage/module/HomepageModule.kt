package learn.clean_architecture.android.presentation.homepage.module

import learn.clean_architecture.android.presentation.homepage.router.HomepageRouter
import org.koin.dsl.module.module

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
val homepageModule = module {
    single { HomepageRouter(get(), get()) }
}