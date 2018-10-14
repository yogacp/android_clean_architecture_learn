package learn.clean_architecture.android.data.network.services

import io.reactivex.Observable
import learn.clean_architecture.android.data.responses.events.Events
import learn.clean_architecture.android.data.responses.leagues.Leagues
import learn.clean_architecture.android.data.responses.teams.Teams
import learn.clean_architecture.android.external.constant.RestConstant
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
interface SportDbServices {
    @GET(RestConstant.SPORTDB.searchAllTeams)
    fun searchAllTeams(@Query("l") l: String): Observable<Teams.Response>

    @GET(RestConstant.SPORTDB.getImageTeams)
    fun getImageTeams(@Query("t") t: String): Observable<Teams.Response>

    @GET(RestConstant.SPORTDB.searchNextEvents)
    fun searchNextEvents(@Query("id") id: String): Observable<Events.Response>

    @GET(RestConstant.SPORTDB.searchPrevEvents)
    fun searchPastEvents(@Query("id") id: String): Observable<Events.Response>

    @GET(RestConstant.SPORTDB.getDetailEvents)
    fun getDetailEvents(@Query("id") id: String): Observable<Events.Response>

    @GET(RestConstant.SPORTDB.getAllLeagues)
    fun getAllLeagues(): Observable<Leagues.Response>
}