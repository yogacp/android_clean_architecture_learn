package learn.clean_architecture.android.domain.router

import android.content.Context
import android.content.Intent

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
interface ScreenRouter {

    sealed class ActivityScreen {
        object Homepage : ActivityScreen()
        object DetailFootballClub : ActivityScreen()
    }

    fun getScreenIntent(context: Context, screen: ActivityScreen): Intent?
}