package orlov.nyt.data.network.model

import com.squareup.moshi.Json

data class Headline(
    @Json(name = "content_kicker")
    val content_kicker: String?,
    @Json(name = "kicker")
    val kicker: String?,
    @Json(name = "main")
    val main: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "print_headline")
    val print_headline: String?,
    @Json(name = "seo")
    val seo: String?,
    @Json(name = "sub")
    val sub: String?
)