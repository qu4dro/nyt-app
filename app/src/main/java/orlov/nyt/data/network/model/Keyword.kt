package orlov.nyt.data.network.model

import com.squareup.moshi.Json

data class Keyword(
    @Json(name = "major")
    val major: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "rank")
    val rank: Int?,
    @Json(name = "value")
    val value: String?
)