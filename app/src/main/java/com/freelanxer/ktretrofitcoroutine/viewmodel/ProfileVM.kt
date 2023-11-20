package com.freelanxer.ktretrofitcoroutine.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.freelanxer.ktretrofitcoroutine.model.ApiResult
import com.freelanxer.ktretrofitcoroutine.model.FollowerListModel
import com.freelanxer.ktretrofitcoroutine.model.ProfileModel
import com.freelanxer.ktretrofitcoroutine.network.Resource
import com.freelanxer.ktretrofitcoroutine.network.Status
import com.freelanxer.ktretrofitcoroutine.repository.ProfileRepository
import kotlinx.coroutines.Dispatchers

class ProfileVM(private val repository: ProfileRepository): ViewModel() {

    private var _followerListModel = MutableLiveData<ApiResult<FollowerListModel>?>()
    val followerListModel: LiveData<ApiResult<FollowerListModel>?> = _followerListModel

    private val _profileModel = MutableLiveData<ApiResult<ProfileModel>?>()
    val profileModel: LiveData<ApiResult<ProfileModel>?> = _profileModel

    fun getFollowerList(owner: LifecycleOwner, account: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getFollowerList(account)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error"))
        }
    }.observe(owner) {
        it?.let {
            when (it.status) {
                Status.SUCCESS -> {
                    _followerListModel.value = it.data
                }
                Status.ERROR -> {

                }
                Status.LOADING -> {

                }
            }
        }
    }

    fun getProfile(owner: LifecycleOwner, account: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getProfile(account)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error"))
        }
    }.observe(owner) {
        it?.let {
            when (it.status) {
                Status.SUCCESS -> {
                    _profileModel.value = it.data
                }
                Status.ERROR -> {

                }
                Status.LOADING -> {

                }
            }
        }
    }

}