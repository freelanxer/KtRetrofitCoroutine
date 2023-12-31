package com.freelanxer.ktretrofitcoroutine.network

class ApiHelper(private val apiService: ApiService) {

    suspend fun getFollowerList(account: String) = apiService.getFollowerList(account)

    suspend fun getProfile(account: String) = apiService.getProfile(account)

    suspend fun getPostList(account: String) = apiService.getPostList(account)

}