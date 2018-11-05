package learn.clean_architecture.android.domain.router.homepage

import android.support.v7.app.AppCompatActivity
import learn.clean_architecture.android.domain.router.ScreenRouter
import learn.clean_architecture.android.external.constant.AppConstant
import learn.clean_architecture.android.presentation.homepage.contract.HomepageContract
import javax.inject.Inject

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
class HomepageRouter @Inject constructor(
    val mScreenRouter: ScreenRouter,
    val mContext: AppCompatActivity
) : HomepageContract.Router {

    override fun goToDetailPage(fcName: String?, fcDesc: String?, fcImage: String?) {
        val mScreen = mScreenRouter.getScreenIntent(mContext, ScreenRouter.ActivityScreen.DetailFootballClub)
        mScreen.apply {
            this?.putExtra(AppConstant.INTENT_BUNDLE.TAG_FCNAME, fcName)
            this?.putExtra(AppConstant.INTENT_BUNDLE.TAG_FCDESC, fcDesc)
            this?.putExtra(AppConstant.INTENT_BUNDLE.TAG_FCIMAGE, fcImage)
        }
        mScreen?.run { mContext.startActivity(this) }
    }

}