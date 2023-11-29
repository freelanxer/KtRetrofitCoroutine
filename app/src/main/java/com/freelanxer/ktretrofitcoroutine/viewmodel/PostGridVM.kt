package com.freelanxer.ktretrofitcoroutine.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.freelanxer.ktretrofitcoroutine.model.ApiResult
import com.freelanxer.ktretrofitcoroutine.model.post.PostListModel
import com.freelanxer.ktretrofitcoroutine.network.Resource
import com.freelanxer.ktretrofitcoroutine.network.Status
import com.freelanxer.ktretrofitcoroutine.repository.PostRepository
import kotlinx.coroutines.Dispatchers

class PostGridVM(
    private val repository: PostRepository
): ViewModel() {
    private var _postListModel = MutableLiveData<ApiResult<PostListModel>?>()
    val postListModel: LiveData<ApiResult<PostListModel>?> = _postListModel

    fun getPostList(owner: LifecycleOwner, account: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getPostList(account)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error"))
        }
    }.observe(owner) {
        it?.let {
            when (it.status) {
                Status.SUCCESS -> {
                    _postListModel.value = it.data
                }
                Status.ERROR -> {

                }
                Status.LOADING -> {

                }
            }
        }
    }

}