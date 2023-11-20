package com.freelanxer.ktretrofitcoroutine.model

data class ProfileModel(
    val avatarUrl: String,      //頭像URL
    val description: String,    //簡介
    val fansCount: Int,         //粉絲數
    val followCount: Int,       //追蹤數
    val photoCount: Int,        //照片數
    val userName: String        //使用者名稱
)
