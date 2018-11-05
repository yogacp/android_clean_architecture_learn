package learn.clean_architecture.android.presentation.detailpage.presenter

import android.os.Bundle
import learn.clean_architecture.android.external.constant.AppConstant
import learn.clean_architecture.android.presentation.detailpage.contract.DetailPageContract
import javax.inject.Inject

/**
 * Created by Yoga C. Pranata on 05/11/2018.
 * Android Engineer
 */
class DetailPagePresenter @Inject constructor(val view: DetailPageContract.View) : DetailPageContract.UserActionListener {

    override fun getFootballClub(bundle: Bundle) {
        bundle.let {
            val teamId = it.getString(AppConstant.INTENT_BUNDLE.TAG_FCID)
            val title = it.getString(AppConstant.INTENT_BUNDLE.TAG_FCNAME)
            val desc = it.getString(AppConstant.INTENT_BUNDLE.TAG_FCDESC)
            val image = it.getString(AppConstant.INTENT_BUNDLE.TAG_FCIMAGE)

            view.setupToolbar(title)
            view.setContentDetail(title, desc, image)
        }
    }

}