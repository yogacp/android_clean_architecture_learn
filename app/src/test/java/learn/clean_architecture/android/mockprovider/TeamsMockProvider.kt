package learn.clean_architecture.android.mockprovider

import io.reactivex.Observable
import learn.clean_architecture.android.data.responses.teams.Teams

/**
 * Created by Yoga C. Pranata on 05/11/2018.
 * Android Engineer
 */
object TeamsMockProvider {
    fun responseData() : Observable<Teams.Response> {
        val teamsData = Teams.TeamsData(
            idTeam = "133604",
            strTeam = "Arsenal",
            strAlternate =  "Gunners",
            intFormedYear = "1892",
            strLeague = "English Premier League"
        )
        val response = Teams.Response(listOf(teamsData))
        return Observable.just(response)
    }
}