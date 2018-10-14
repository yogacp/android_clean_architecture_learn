package learn.clean_architecture.android.data.responses.events

import com.google.gson.annotations.SerializedName

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
sealed class Events {
    data class Response (
        @SerializedName("events")
        var events : ArrayList<EventsData>? = null
    )

    data class EventsData(
        @SerializedName("idEvent")
        var idEvent: String? = null,
        @SerializedName("idSoccerXML")
        var idSoccerXML: String? = null,
        @SerializedName("strEvent")
        var strEvent: String? = null,
        @SerializedName("strFilename")
        var strFilename: String? = null,
        @SerializedName("strSport")
        var strSport: String? = null,
        @SerializedName("idLeague")
        var idLeague: String? = null,
        @SerializedName("strLeague")
        var strLeague: String? = null,
        @SerializedName("strSeason")
        var strSeason: String? = null,
        @SerializedName("strDescriptionEN")
        var strDescriptionEN: Any? = null,
        @SerializedName("strHomeTeam")
        var strHomeTeam: String? = null,
        @SerializedName("strAwayTeam")
        var strAwayTeam: String? = null,
        @SerializedName("intHomeScore")
        var intHomeScore: String? = null,
        @SerializedName("intRound")
        var intRound: String? = null,
        @SerializedName("intAwayScore")
        var intAwayScore: String? = null,
        @SerializedName("intSpectators")
        var intSpectators: String? = null,
        @SerializedName("strHomeGoalDetails")
        var strHomeGoalDetails: String? = null,
        @SerializedName("strHomeRedCards")
        var strHomeRedCards: String? = null,
        @SerializedName("strHomeYellowCards")
        var strHomeYellowCards: String? = null,
        @SerializedName("strHomeLineupGoalkeeper")
        var strHomeLineupGoalkeeper: String? = null,
        @SerializedName("strHomeLineupDefense")
        var strHomeLineupDefense: String? = null,
        @SerializedName("strHomeLineupMidfield")
        var strHomeLineupMidfield: String? = null,
        @SerializedName("strHomeLineupForward")
        var strHomeLineupForward: String? = null,
        @SerializedName("strHomeLineupSubstitutes")
        var strHomeLineupSubstitutes: String? = null,
        @SerializedName("strHomeFormation")
        var strHomeFormation: String? = null,
        @SerializedName("strAwayRedCards")
        var strAwayRedCards: String? = null,
        @SerializedName("strAwayYellowCards")
        var strAwayYellowCards: String? = null,
        @SerializedName("strAwayGoalDetails")
        var strAwayGoalDetails: String? = null,
        @SerializedName("strAwayLineupGoalkeeper")
        var strAwayLineupGoalkeeper: String? = null,
        @SerializedName("strAwayLineupDefense")
        var strAwayLineupDefense: String? = null,
        @SerializedName("strAwayLineupMidfield")
        var strAwayLineupMidfield: String? = null,
        @SerializedName("strAwayLineupForward")
        var strAwayLineupForward: String? = null,
        @SerializedName("strAwayLineupSubstitutes")
        var strAwayLineupSubstitutes: String? = null,
        @SerializedName("strAwayFormation")
        var strAwayFormation: String? = null,
        @SerializedName("intHomeShots")
        var intHomeShots: Any? = null,
        @SerializedName("intAwayShots")
        var intAwayShots: Any? = null,
        @SerializedName("dateEvent")
        var dateEvent: String? = null,
        @SerializedName("strDate")
        var strDate: String? = null,
        @SerializedName("strTime")
        var strTime: String? = null,
        @SerializedName("strTVStation")
        var strTVStation: Any? = null,
        @SerializedName("idHomeTeam")
        var idHomeTeam: String? = null,
        @SerializedName("idAwayTeam")
        var idAwayTeam: String? = null,
        @SerializedName("strResult")
        var strResult: Any? = null,
        @SerializedName("strCircuit")
        var strCircuit: Any? = null,
        @SerializedName("strCountry")
        var strCountry: Any? = null,
        @SerializedName("strCity")
        var strCity: Any? = null,
        @SerializedName("strPoster")
        var strPoster: Any? = null,
        @SerializedName("strFanart")
        var strFanart: Any? = null,
        @SerializedName("strThumb")
        var strThumb: Any? = null,
        @SerializedName("strBanner")
        var strBanner: Any? = null,
        @SerializedName("strMap")
        var strMap: Any? = null,
        @SerializedName("strLocked")
        var strLocked: String? = null
    )
}