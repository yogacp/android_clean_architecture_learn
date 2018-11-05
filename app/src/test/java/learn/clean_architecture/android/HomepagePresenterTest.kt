package learn.clean_architecture.android

import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import learn.clean_architecture.android.domain.usecase.homepage.HomepageUseCase
import learn.clean_architecture.android.mockprovider.LeaguesMockProvider
import learn.clean_architecture.android.mockprovider.TeamsMockProvider
import learn.clean_architecture.android.presentation.homepage.contract.HomepageContract
import learn.clean_architecture.android.presentation.homepage.presenter.HomepagePresenter
import org.junit.Before
import org.junit.Test

/**
 * Created by Yoga C. Pranata on 05/11/2018.
 * Android Engineer
 */
class HomepagePresenterTest {
    private var usecase = mockk<HomepageUseCase>()
    private var mView: HomepageContract.View = spyk()
    private lateinit var mPresenter: HomepagePresenter

    @Before
    fun setup() {
        usecase = mockk()
        mPresenter = HomepagePresenter(mView, usecase)
    }

    @Test
    fun shouldGetAllLeaguesFromApi() {
        val leaguesData = LeaguesMockProvider.responseData()

        every { usecase.getAllLeagues() } answers { leaguesData }

        mPresenter.getAllLeagues()

        verify(exactly = 1) { mView.showProgressBar() }
        verify(exactly = 1) { mView.hideEmptyView() }
    }

    @Test
    fun shouldGetListFootballClubFromApi() {
        val searchTeams = "English Premier League"
        val teamsData = TeamsMockProvider.responseData()

        every { usecase.searchAllTeams(searchTeams) } answers { teamsData }

        mPresenter.getListFootballClub(searchTeams)

        verify(exactly = 1) { mView.showProgressBar() }
        verify(exactly = 1) { mView.hideEmptyView() }
    }
}
