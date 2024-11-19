package com.lazamelezi.simplenews.data.response

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class NewsResponse(
    val articles: List<NewsArticle>,

    var status: String,

    val totalResults: Int
)
