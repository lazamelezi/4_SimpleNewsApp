package com.lazamelezi.simplenews.data.response

import com.squareup.moshi.JsonClass



@JsonClass(generateAdapter = true)
data class NewsError(
    val code: String,

    val message: String,

    val status: String
)
