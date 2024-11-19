package com.lazamelezi.simplenews.data.repository

import com.lazamelezi.simplenews.data.Result
import com.lazamelezi.simplenews.data.apiservice.SimpleNewsApiService
import com.lazamelezi.simplenews.data.response.NewsError
import com.lazamelezi.simplenews.data.response.NewsResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext



class NewsRepositoryImpl @Inject constructor(
    private val newsApiService: SimpleNewsApiService,
    private val moshi: Moshi
) : NewsRepository {
    private val defaultDispatcher = Dispatchers.Default
    private val map = HashMap<String,Result.Success<NewsResponse>>()
    override suspend fun getArticlesByCategoryAsync(
        category: String,
        page: Int
    ): Result<NewsResponse> {
        if(map.containsKey(category)){
            return map[category] as Result<NewsResponse>
        } else {
            try {
                val response = newsApiService.getArticlesByCateGoryAsync(category)
                return if (response.isSuccessful) {
                    if (response.body() != null) {
                        map[category] = Result.Success(response.body()!!)
                        Result.Success(response.body()!!)
                    } else {
                        Result.Error("No Data found")
                    }
                } else {
                    val jsonAdapter: JsonAdapter<NewsError> = moshi.adapter(
                        NewsError::class.java
                    )
                    withContext(defaultDispatcher) {
                        val newsError = jsonAdapter.fromJson(response.errorBody()?.string()!!)
                        Result.Error(
                            newsError!!.message,
                            showRetry(newsError.code)
                        )
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                var errorMessage = e.localizedMessage
                if (e.localizedMessage!!.contains("Unable to resolve host")) {
                    errorMessage = "No internet connection"
                }
                return Result.Error(errorMessage ?: "Something went wrong")
            }
        }
    }

    private fun showRetry(code: String): Boolean = when (code) {
        "apiKeyDisabled", "apiKeyExhausted", "apiKeyInvalid", "apiKeyMissing" -> false
        else -> true
    }
}
