package learn.clean_architecture.android.domain.router

import android.content.Context
import android.content.Intent

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
class ScreenRouterImpl : ScreenRouter {

    override fun getScreenIntent(context: Context, screen: ScreenRouter.ActivityScreen): Intent? {
        val c: Class<*>? = when (screen) {
            ScreenRouter.ActivityScreen.DetailFootballClub -> null
        }
        return if (c == null) null else Intent(context, c)
    }

}