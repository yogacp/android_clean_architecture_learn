package learn.clean_architecture.android.mockprovider

import io.reactivex.Observable
import learn.clean_architecture.android.data.responses.leagues.Leagues

/**
 * Created by Yoga C. Pranata on 05/11/2018.
 * Android Engineer
 */
object LeaguesMockProvider {
    fun responseData(): Observable<Leagues.Response> {
        val leaguesData = Leagues.LeaguesData(
            idLeague = "4406",
            strSport = "Soccer",
            strLeague = "Argentinian Primera Division",
            dateFirstEvent = "Argentina",
            strDescriptionES = "El campeonato de Primera División del fútbol argentino es un torneo organizado por la Asociación del Fútbol Argentino (AFA) y es la máxima categoría del sistema de campeonatos de dicho deporte en Argentina.\r\n\r\nEn el certamen actual participan treinta equipos, los que son presentados por clubes, asociaciones civiles sin fines de lucro, aunque desde el año 2000 puede darse la situación de que el equipo esté gerenciado por una empresa privada, en representación y con la aprobación del club respectivo.\r\n\r\nA pesar de haberse decidido oficialmente que, a partir del Campeonato 2015, se cambiaría el modelo de dos torneos cortos, utilizando calendario europeo, a un solo concurso que transcurriría en el año calendario, aumentando el número de participantes a 30 equipos,9 en su reunión del 11 de noviembre de 2014, el Comité Ejecutivo de la Asociación propuso una revisión de lo actuado. Por ese motivo se produjo una controversia sobre el modo de disputa y el calendario de ese certamen,10 11 12 13 14 aunque finalmente, ante la intervención de directivos de la televisión y el gobierno, se propuso respetar lo acordado en la reunión del 3 de junio de 2014 y ratificar el modo de disputa del torneo.15\r\n\r\nEl concurso se realiza en una ronda de todos contra todos, con el agregado de un partido según los emparejamientos realizados por la Asociación, basado, en la mayoría de los casos, en los que se consideran rivales clásicos. Esos partidos se jugarán en la 24.ª fecha y en los mismos se invertirá la condición de local con respecto al otro enfrentamiento. De esta manera, cada equipo disputará un total de 30 partidos.\r\n\r\nPor otro lado, se producirán dos descensos a la segunda división, la Primera B Nacional, determinados según la tabla de promedios de los cuatro últimos torneos. Asimismo, se producirá la clasificación de 3 equipos a la Copa Libertadores 2016 y de otros 5 a la Copa Sudamericana del mismo año, cuyos cupos se completarán con la realización de dos liguillas, método que se reflotará luego de haberse empleado por última vez en la temporada 1991/92.\r\n\r\nEl Campeonato de Primera División es uno de los mejores del mundo de acuerdo con la Federación Internacional de Historia y Estadística de Fútbol. En la última clasificación, la del año 2014, ocupa el cuarto puesto en el ranking anual de dicha institución,16 que se elabora desde 1991. La Primera División de Argentina, a excepción de 1993, siempre estuvo entre las diez primeras. Su mejor ubicación en este ranking se dio en 2008, cuando logró el tercer lugar, siendo superada apenas por la Premier League de Inglaterra y por la Serie A de Italia. Estas mismas ligas son las que ocupan los tres primeros lugares del escalafón actual, junto con la Primera División de España.",
            strBadge = "https://www.thesportsdb.com/images/media/league/badge/me5dez1517699947.png"
        )
        val response = Leagues.Response(listOf(leaguesData))
        return Observable.just(response)
    }
}