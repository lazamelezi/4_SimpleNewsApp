package com.lazamelezi.simplenews.data.repository

import com.lazamelezi.simplenews.data.Result
import com.lazamelezi.simplenews.data.response.NewsResponse


interface NewsRepository {
    suspend fun getArticlesByCategoryAsync(category: String, page: Int): Result<NewsResponse>
}
