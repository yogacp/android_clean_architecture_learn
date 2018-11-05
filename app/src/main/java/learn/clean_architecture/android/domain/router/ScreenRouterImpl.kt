package learn.clean_architecture.android.domain.router

import android.content.Context
import android.content.Intent
import learn.clean_architecture.android.presentation.detailpage.view.DetailPageActivity

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
class ScreenRouterImpl : ScreenRouter {

    override fun getScreenIntent(context: Context, screen: ScreenRouter.ActivityScreen): Intent? {
        val c: Class<*>? = when (screen) {
            ScreenRouter.ActivityScreen.DetailFootballClub -> DetailPageActivity::class.java
        }
        return if (c == null) null else Intent(context, c)
    }

}