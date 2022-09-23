package orlov.nyt.data.network.model

import com.squareup.moshi.Json

data class Doc(
    @Json(name = "_id")
    val _id: String,
    @Json(name = "abstract")
    val abstract: String,
    @Json(name = "byline")
    val byline: Byline,
    @Json(name = "document_type")
    val document_type: String,
    @Json(name = "headline")
    val headline: Headline,
    @Json(name = "keywords")
    val keywords: List<Keyword>,
    @Json(name = "lead_paragraph")
    val lead_paragraph: String,
    @Json(name = "multimedia")
    val multimedia: List<Multimedia>?,
    @Json(name = "news_desk")
    val news_desk: String,
    @Json(name = "print_page")
    val print_page: String?,
    @Json(name = "print_section")
    val print_section: String?,
    @Json(name = "pub_date")
    val pub_date: String?,
    @Json(name = "section_name")
    val section_name: String?,
    @Json(name = "snippet")
    val snippet: String?,
    @Json(name = "source")
    val source: String,
    @Json(name = "subsection_name")
    val subsection_name: String?,
    @Json(name = "type_of_material")
    val type_of_material: String?,
    @Json(name = "uri")
    val uri: String?,
    @Json(name = "web_url")
    val web_url: String?,
    @Json(name = "word_count")
    val word_count: Int
)