package orlov.nyt.data.network.model

import com.squareup.moshi.Json

data class Person(
    @Json(name = "firstname")
    val firstname: String?,
    @Json(name = "lastname")
    val lastname: String?,
    @Json(name = "middlename")
    val middlename: String?,
    @Json(name = "organization")
    val organization: String?,
    @Json(name = "qualifier")
    val qualifier: String?,
    @Json(name = "rank")
    val rank: Int?,
    @Json(name = "role")
    val role: String?,
    @Json(name = "title")
    val title: String?
)