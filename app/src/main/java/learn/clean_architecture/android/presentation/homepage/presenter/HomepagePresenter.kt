package learn.clean_architecture.android.presentation.homepage.presenter

import io.reactivex.disposables.CompositeDisposable
import learn.clean_architecture.android.data.responses.teams.Teams
import learn.clean_architecture.android.domain.usecase.homepage.HomepageUseCase
import learn.clean_architecture.android.external.scheduler.SchedulerProvider
import learn.clean_architecture.android.presentation.homepage.contract.HomepageContract
import javax.inject.Inject

/**
 * Created by Yoga C. Pranata on 15/10/2018.
 * Android Engineer
 */
class HomepagePresenter @Inject constructor(
    val view: HomepageContract.View,
    val mUseCase: HomepageUseCase
) : HomepageContract.UserActionListener {

    private var mCompositeDisposable = CompositeDisposable()

    override fun getListFootballClub(league: String) {
        view.showProgressBar()
        view.hideEmptyView()
        mCompositeDisposable.add(
            mUseCase.searchAllTeams(league).subscribe({ response ->
                view.hideProgressBar()
                if (response.teams != null) {
                    val teamList = ArrayList<Teams.TeamsData>()
                    response.teams?.forEach {
                        teamList.add(it)
                    }
                    view.setupAdapter(teamList)
                } else {
                    view.showEmptyView()
                    view.clearTeamList()
                }
            }, { error ->
                view.hideProgressBar()
                view.showEmptyView()
                view.clearTeamList()
                view.showError("Error while fetching club list")
            })
        )
    }

    override fun getAllLeagues() {
        view.showProgressBar()
        view.hideEmptyView()
        mCompositeDisposable.add(
            mUseCase.getAllLeagues().subscribe({ response ->
                val leaguesName = ArrayList<String>()
                response.leagues?.forEach {
                    leaguesName.add(it.strLeague!!)
                }
                view.hideProgressBar()
                view.setupLeaguesAdapter(leaguesName)
            }, { error ->
                view.hideProgressBar()
                view.showEmptyView()
                view.showError("Error while fetching all leagues")
            })
        )
    }

}