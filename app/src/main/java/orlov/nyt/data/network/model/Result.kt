package orlov.nyt.data.network.model

import com.squareup.moshi.Json

data class Result(
    @Json(name = "abstract")
    val abstract: String,
    @Json(name = "byline")
    val byline: String,
    @Json(name = "created_date")
    val created_date: String,
    @Json(name = "des_facet")
    val des_facet: List<String>,
    @Json(name = "geo_facet")
    val geo_facet: List<String>,
    @Json(name = "item_type")
    val item_type: String,
    @Json(name = "kicker")
    val kicker: String,
    @Json(name = "material_type_facet")
    val material_type_facet: String,
    @Json(name = "multimedia")
    val multimedia: List<Multimedia>?,
    @Json(name = "org_facet")
    val org_facet: List<String>,
    @Json(name = "per_facet")
    val per_facet: List<String>,
    @Json(name = "published_date")
    val published_date: String,
    @Json(name = "section")
    val section: String,
    @Json(name = "short_url")
    val short_url: String,
    @Json(name = "subsection")
    val subsection: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "updated_date")
    val updated_date: String,
    @Json(name = "uri")
    val uri: String,
    @Json(name = "url")
    val url: String
)