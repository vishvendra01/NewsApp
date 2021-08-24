package com.app.newsapp.api

import com.app.newsapp.BuildConfig
import retrofit2.Response
import retrofit2.http.GET

interface NewsApi {

    @GET("top-headlines?apiKey=${BuildConfig.NEWS_API_KEY}&category=technology")
    suspend fun getTopHeadlines(): Response<NewsResponse>
}