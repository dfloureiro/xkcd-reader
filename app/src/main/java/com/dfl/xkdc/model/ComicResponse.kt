package com.dfl.xkdc.model

import com.squareup.moshi.Json


data class ComicResponse(
        @Json(name = "month") val month: String,
        @Json(name = "num") val num: Int,
        @Json(name = "link") val link: String,
        @Json(name = "year") val year: String,
        @Json(name = "news") val news: String,
        @Json(name = "safe_title") val safeTitle: String,
        @Json(name = "transcript") val transcript: String,
        @Json(name = "alt") val alt: String,
        @Json(name = "img") val img: String,
        @Json(name = "title") val title: String,
        @Json(name = "day") val day: String
)