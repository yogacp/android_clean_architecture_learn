package learn.clean_architecture.android.data.network.repository

import io.reactivex.Observable
import learn.clean_architecture.android.data.responses.events.Events
import learn.clean_architecture.android.data.responses.leagues.Leagues
import learn.clean_architecture.android.data.responses.teams.Teams

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
interface SportDbRepository {
    fun searchAllTeams(league: String): Observable<Teams.Response>
    fun getAllLeagues(): Observable<Leagues.Response>
    fun searchNextEvents(id: String): Observable<Events.Response>
    fun searchPastEvents(id: String): Observable<Events.Response>
    fun getEventDetails(id: String) : Observable<Events.Response>
    fun getImageTeam(team: String)  : Observable<Teams.Response>
}