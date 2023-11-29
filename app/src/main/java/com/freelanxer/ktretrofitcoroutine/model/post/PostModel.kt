package com.freelanxer.ktretrofitcoroutine.model.post

data class PostModel(
    var postID: String,     //貼文ID
    var caption: String,    //內文
    var photoUrl: String,   //照片URL
    var likeCount: Int,     //按讚數
    var postTime: String,   //發布時間
    var shareCount: Int     //分享數
)
