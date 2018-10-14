package learn.clean_architecture.android.data.responses.leagues

import com.google.gson.annotations.SerializedName

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
sealed class Leagues {
    data class Response(
        @SerializedName("countrys")
        var leagues: List<LeaguesData>? = null
    )

    data class LeaguesData(
        @SerializedName("idLeague")
        var idLeague: String? = null,
        @SerializedName("idSoccerXML")
        var idSoccerXML: Any? = null,
        @SerializedName("strSport")
        var strSport: String? = null,
        @SerializedName("strLeague")
        var strLeague: String? = null,
        @SerializedName("strLeagueAlternate")
        var strLeagueAlternate: String? = null,
        @SerializedName("idCup")
        var idCup: String? = null,
        @SerializedName("intFormedYear")
        var intFormedYear: String? = null,
        @SerializedName("dateFirstEvent")
        var dateFirstEvent: String? = null,
        @SerializedName("strGender")
        var strGender: String? = null,
        @SerializedName("strCountry")
        var strCountry: String? = null,
        @SerializedName("strWebsite")
        var strWebsite: String? = null,
        @SerializedName("strFacebook")
        var strFacebook: String? = null,
        @SerializedName("strTwitter")
        var strTwitter: String? = null,
        @SerializedName("strYoutube")
        var strYoutube: String? = null,
        @SerializedName("strRSS")
        var strRSS: String? = null,
        @SerializedName("strDescriptionEN")
        var strDescriptionEN: String? = null,
        @SerializedName("strDescriptionDE")
        var strDescriptionDE: Any? = null,
        @SerializedName("strDescriptionFR")
        var strDescriptionFR: String? = null,
        @SerializedName("strDescriptionIT")
        var strDescriptionIT: Any? = null,
        @SerializedName("strDescriptionCN")
        var strDescriptionCN: Any? = null,
        @SerializedName("strDescriptionJP")
        var strDescriptionJP: Any? = null,
        @SerializedName("strDescriptionRU")
        var strDescriptionRU: Any? = null,
        @SerializedName("strDescriptionES")
        var strDescriptionES: String? = null,
        @SerializedName("strDescriptionPT")
        var strDescriptionPT: Any? = null,
        @SerializedName("strDescriptionSE")
        var strDescriptionSE: Any? = null,
        @SerializedName("strDescriptionNL")
        var strDescriptionNL: Any? = null,
        @SerializedName("strDescriptionHU")
        var strDescriptionHU: Any? = null,
        @SerializedName("strDescriptionNO")
        var strDescriptionNO: Any? = null,
        @SerializedName("strDescriptionPL")
        var strDescriptionPL: Any? = null,
        @SerializedName("strFanart1")
        var strFanart1: String? = null,
        @SerializedName("strFanart2")
        var strFanart2: Any? = null,
        @SerializedName("strFanart3")
        var strFanart3: Any? = null,
        @SerializedName("strFanart4")
        var strFanart4: Any? = null,
        @SerializedName("strBanner")
        var strBanner: Any? = null,
        @SerializedName("strBadge")
        var strBadge: String? = null,
        @SerializedName("strLogo")
        var strLogo: String? = null,
        @SerializedName("strPoster")
        var strPoster: Any? = null,
        @SerializedName("strTrophy")
        var strTrophy: String? = null,
        @SerializedName("strNaming")
        var strNaming: String? = null,
        @SerializedName("strLocked")
        var strLocked: String? = null
    )
}