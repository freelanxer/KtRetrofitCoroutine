package com.freelanxer.ktretrofitcoroutine.repository

import com.freelanxer.ktretrofitcoroutine.network.ApiHelper

class ProfileRepository(private val apiHelper: ApiHelper) {
    suspend fun getFollowerList(account: String) = apiHelper.getFollowerList(account)
}