package orlov.nyt.data.network.model

import com.squareup.moshi.Json

data class SearchNewsResponse(
    @Json(name = "copyright")
    val copyright: String,
    @Json(name = "response")
    val results: Response,
    @Json(name = "status")
    val status: String
)