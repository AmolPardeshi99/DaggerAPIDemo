package dev.amol.daggerapidemo.repository

import dev.amol.daggerapidemo.data.remote.api.APIService
import dev.amol.daggerapidemo.data.remote.responsedata.ResponseData
import javax.inject.Inject

class DaggerDemoRepository @Inject constructor(val apiService: APIService) {

    suspend fun fetchData(): ResponseData {
        return apiService.getNewsFromAPI()
    }
}