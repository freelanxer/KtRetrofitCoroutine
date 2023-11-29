package com.freelanxer.ktretrofitcoroutine.repository

import com.freelanxer.ktretrofitcoroutine.network.ApiHelper

class PostRepository(private val apiHelper: ApiHelper) {
    suspend fun getPostList(account: String) = apiHelper.getPostList(account)
}