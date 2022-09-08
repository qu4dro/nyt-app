package orlov.nyt.data.network.service

import orlov.nyt.BuildConfig
import orlov.nyt.data.network.model.TopNewsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsService {

    @GET("topstories/v2/{section}.json")
    suspend fun fetchTopNews(
        @Path("section") section: String = "home",
        @Query("api-key") api_key: String = BuildConfig.API_KEY
    ): TopNewsResponse

}