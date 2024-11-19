package com.lazamelezi.simplenews.data.response

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class NewsSource(
    val name: String?
)
