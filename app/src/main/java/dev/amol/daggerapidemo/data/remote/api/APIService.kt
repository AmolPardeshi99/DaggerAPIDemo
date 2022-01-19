package dev.amol.daggerapidemo.data.remote.api

import dev.amol.daggerapidemo.data.Utility.TOP_HEADLINE
import dev.amol.daggerapidemo.data.remote.responsedata.ResponseData
import retrofit2.http.GET

interface APIService {

    @GET(TOP_HEADLINE)
    suspend fun getNewsFromAPI(): ResponseData

}