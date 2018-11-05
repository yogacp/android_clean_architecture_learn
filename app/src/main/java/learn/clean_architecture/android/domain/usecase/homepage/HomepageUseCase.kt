package learn.clean_architecture.android.domain.usecase.homepage

import io.reactivex.Observable
import learn.clean_architecture.android.data.responses.leagues.Leagues
import learn.clean_architecture.android.data.responses.teams.Teams

/**
 * Created by Yoga C. Pranata on 15/10/2018.
 * Android Engineer
 */
interface HomepageUseCase {
    fun searchAllTeams(league: String) : Observable<Teams.Response>
    fun getAllLeagues() : Observable<Leagues.Response>
}