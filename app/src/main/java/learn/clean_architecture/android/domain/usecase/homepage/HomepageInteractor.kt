package learn.clean_architecture.android.domain.usecase.homepage

import io.reactivex.Observable
import learn.clean_architecture.android.data.network.repository.SportDbRepository
import learn.clean_architecture.android.data.responses.leagues.Leagues
import learn.clean_architecture.android.data.responses.teams.Teams
import javax.inject.Inject

/**
 * Created by Yoga C. Pranata on 15/10/2018.
 * Android Engineer
 */
class HomepageInteractor @Inject constructor(val mRepository: SportDbRepository) : HomepageUseCase {

    override fun searchAllTeams(league: String): Observable<Teams.Response> {
        return mRepository.searchAllTeams(league).flatMap {
            Observable.just(it)
        }
    }

    override fun getAllLeagues(): Observable<Leagues.Response> {
        return mRepository.getAllLeagues().flatMap {
            Observable.just(it)
        }
    }
}