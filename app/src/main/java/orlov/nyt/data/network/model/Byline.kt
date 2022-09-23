package orlov.nyt.data.network.model

import com.squareup.moshi.Json

data class Byline(
    @Json(name = "organization")
    val organization: String?,
    @Json(name = "original")
    val original: String?,
    @Json(name = "person")
    val person: List<Person>?
)