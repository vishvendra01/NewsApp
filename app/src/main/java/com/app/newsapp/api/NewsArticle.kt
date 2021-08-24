package com.app.newsapp.api

import com.google.gson.annotations.SerializedName

data class NewsArticle(
    @SerializedName("source")
    val source: Source,

    @SerializedName("author")
    val author: String? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("url")
    val url: String? = null,

    @SerializedName("urlToImage")
    val urlToImage: String? = null,

    @SerializedName("publishedAt")
    val publishedAt: String? = null,

    @SerializedName("content")
    val content: String? = null
) {
    data class Source(
        @SerializedName("id")
        val id: String? = null,

        @SerializedName("name")
        val name: String? = null
    )
}
