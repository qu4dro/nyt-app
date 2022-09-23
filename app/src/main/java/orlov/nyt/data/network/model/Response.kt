package orlov.nyt.data.network.model

import com.squareup.moshi.Json

data class Response(
    @Json(name = "docs")
    val docs: List<Doc>,
    @Json(name = "meta")
    val meta: Meta
)