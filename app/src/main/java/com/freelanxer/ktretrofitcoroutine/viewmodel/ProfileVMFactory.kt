package com.freelanxer.ktretrofitcoroutine.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.freelanxer.ktretrofitcoroutine.network.ApiHelper
import com.freelanxer.ktretrofitcoroutine.repository.ProfileRepository

class ProfileVMFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileVM::class.java)) {
            return ProfileVM(ProfileRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}