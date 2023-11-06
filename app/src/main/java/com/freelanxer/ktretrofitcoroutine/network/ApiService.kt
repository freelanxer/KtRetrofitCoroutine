package com.freelanxer.ktretrofitcoroutine.network

import com.freelanxer.ktretrofitcoroutine.model.ApiResult
import com.freelanxer.ktretrofitcoroutine.model.FollowerListModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("Profile/GetFollowerList")
    suspend fun getFollowerList(@Query("account") account: String): ApiResult<FollowerListModel>

}