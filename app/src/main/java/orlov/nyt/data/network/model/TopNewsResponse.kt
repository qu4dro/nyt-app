package orlov.nyt.data.network.model

import com.squareup.moshi.Json

data class TopNewsResponse(
    @Json(name = "copyright")
    val copyright: String,
    @Json(name = "last_updated")
    val last_updated: String,
    @Json(name = "num_results")
    val num_results: Int,
    @Json(name = "results")
    val results: List<Result>,
    @Json(name = "section")
    val section: String,
    @Json(name = "status")
    val status: String
)