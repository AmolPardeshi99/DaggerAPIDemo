package dev.amol.daggerapidemo.data.remote.responsedata

data class ResponseData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)