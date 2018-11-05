package learn.clean_architecture.android.data.responses.teams

import com.google.gson.annotations.SerializedName

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
sealed class Teams {
    data class Response (
        @SerializedName("teams") var teams: List<TeamsData>? = null
    )

    data class TeamsData(
        @SerializedName("idTeam")
        var idTeam: String? = null,
        @SerializedName("strTeam")
        var strTeam: String? = null,
        @SerializedName("strAlternate")
        var strAlternate: String? = null,
        @SerializedName("intFormedYear")
        var intFormedYear: String? = null,
        @SerializedName("strLeague")
        var strLeague: String? = null,
        @SerializedName("idLeague")
        var idLeague: String? = null,
        @SerializedName("strManager")
        var strManager: String? = null,
        @SerializedName("strStadium")
        var strStadium: String? = null,
        @SerializedName("strStadiumThumb")
        var strStadiumThumb: String? = null,
        @SerializedName("strDescriptionEN")
        var strDescriptionEN: String? = null,
        @SerializedName("strCountry")
        var strCountry: String? = null,
        @SerializedName("strTeamBadge")
        var strTeamBadge: String? = null,
        @SerializedName("strTeamJersey")
        var strTeamJersey: String? = null,
        @SerializedName("strTeamLogo")
        var strTeamLogo: String? = null,
        @SerializedName("strTeamFanart1")
        var strTeamFanart1: String? = null,
        @SerializedName("strTeamFanart2")
        var strTeamFanart2: String? = null,
        @SerializedName("strTeamFanart3")
        var strTeamFanart3: String? = null,
        @SerializedName("strTeamFanart4")
        var strTeamFanart4: String? = null,
        @SerializedName("strTeamBanner")
        var strTeamBanner: String? = null,
        @SerializedName("strYoutube")
        var strYoutube: String? = null
    )
}