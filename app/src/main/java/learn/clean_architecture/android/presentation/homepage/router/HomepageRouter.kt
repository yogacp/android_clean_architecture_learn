package learn.clean_architecture.android.presentation.homepage.router

import android.support.v7.app.AppCompatActivity
import learn.clean_architecture.android.domain.router.ScreenRouter
import learn.clean_architecture.android.presentation.homepage.contract.HomepageContract

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
class HomepageRouter constructor(
    val mScreenRouter: ScreenRouter,
    val mContext: AppCompatActivity
) : HomepageContract.Router {



}