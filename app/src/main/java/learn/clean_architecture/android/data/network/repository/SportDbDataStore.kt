package learn.clean_architecture.android.data.network.repository

import io.reactivex.Observable
import learn.clean_architecture.android.data.network.services.SportDbServices
import learn.clean_architecture.android.data.responses.events.Events
import learn.clean_architecture.android.data.responses.leagues.Leagues
import learn.clean_architecture.android.data.responses.teams.Teams
import learn.clean_architecture.android.external.scheduler.SchedulerProvider

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
class SportDbDataStore constructor(
    val mService: SportDbServices,
    val mScheduler: SchedulerProvider
) : SportDbRepository {

    override fun searchAllTeams(league: String): Observable<Teams.Response> {
        return mService.searchAllTeams(league)
            .subscribeOn(mScheduler.io())
            .observeOn(mScheduler.mainThread())
    }

    override fun getAllLeagues(): Observable<Leagues.Response> {
        return mService.getAllLeagues()
            .subscribeOn(mScheduler.io())
            .observeOn(mScheduler.mainThread())
    }

    override fun searchNextEvents(id: String): Observable<Events.Response> {
        return mService.searchNextEvents(id)
            .subscribeOn(mScheduler.io())
            .observeOn(mScheduler.mainThread())
    }

    override fun searchPastEvents(id: String): Observable<Events.Response> {
        return mService.searchPastEvents(id)
            .subscribeOn(mScheduler.io())
            .observeOn(mScheduler.mainThread())
    }

    override fun getEventDetails(id: String): Observable<Events.Response> {
        return mService.getDetailEvents(id)
            .subscribeOn(mScheduler.io())
            .observeOn(mScheduler.mainThread())
    }

    override fun getImageTeam(team: String): Observable<Teams.Response> {
        return mService.getImageTeams(team)
            .subscribeOn(mScheduler.io())
            .observeOn(mScheduler.mainThread())
    }

}