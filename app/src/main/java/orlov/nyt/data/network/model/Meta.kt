package orlov.nyt.data.network.model

import com.squareup.moshi.Json

data class Meta(
    @Json(name = "hints")
    val hits: Int?,
    @Json(name = "offset")
    val offset: Int?,
    @Json(name = "time")
    val time: Int?
)