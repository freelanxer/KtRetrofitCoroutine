package com.freelanxer.ktretrofitcoroutine

import android.util.Log

object Constant {
    val DEBUG = BuildConfig.BUILD_TYPE.contentEquals("debug")
    private const val TAG = "KT_RETROFIT"

    fun logD(msg: String, throwable: Throwable? = null) = Log.d(TAG, msg, throwable)
    fun logI(msg: String, throwable: Throwable? = null) = Log.i(TAG, msg, throwable)
    fun logW(msg: String, throwable: Throwable? = null) = Log.w(TAG, msg, throwable)
    fun logE(msg: String, throwable: Throwable? = null) = Log.e(TAG, msg, throwable)
}