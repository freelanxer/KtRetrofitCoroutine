package com.freelanxer.ktretrofitcoroutine.network

class ApiHelper(private val apiService: ApiService) {

    suspend fun getFollowerList(account: String) = apiService.getFollowerList(account)

}