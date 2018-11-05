package learn.clean_architecture.android.presentation.homepage.contract

import android.widget.ImageView
import android.widget.ProgressBar
import learn.clean_architecture.android.data.responses.teams.Teams

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
class HomepageContract {
    interface View {
        fun onAutoAndroidInjector()
        fun initData()
        fun loadImageToImageView(imageSource: String, imgView: ImageView, progressBar: ProgressBar)
        fun setupAdapter(fcList: ArrayList<Teams.TeamsData>?)
        fun setupLeaguesAdapter(leagues: ArrayList<String>)
        fun setupToolbar(title: String?)
        fun setupUiSpinner()
        fun showError(message: String)
        fun showProgressBar()
        fun hideProgressBar()
        fun showEmptyView()
        fun hideEmptyView()
        fun clearTeamList()
    }

    interface UserActionListener {
        fun getListFootballClub(league: String)
        fun getAllLeagues()
    }

    interface Router {
        fun goToDetailPage(fcName: String?, fcDesc: String?, fcImage: String?)
    }
}