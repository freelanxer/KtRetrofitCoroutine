package com.freelanxer.ktretrofitcoroutine.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.freelanxer.ktretrofitcoroutine.R
import com.freelanxer.ktretrofitcoroutine.databinding.ActivityProfileBinding
import com.freelanxer.ktretrofitcoroutine.network.ApiHelper
import com.freelanxer.ktretrofitcoroutine.network.RetrofitBuilder
import com.freelanxer.ktretrofitcoroutine.viewmodel.ProfileVM
import com.freelanxer.ktretrofitcoroutine.viewmodel.ProfileVMFactory
import com.google.android.material.imageview.ShapeableImageView

class ProfileActivity: BaseActivity() {
    companion object {
        const val EXTRA_NAME_ACCOUNT = "EXTRA_NAME_ACCOUNT"
    }
    private lateinit var mBinding: ActivityProfileBinding
    private lateinit var mProfileVM: ProfileVM
    private lateinit var mAccount: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAccount = intent.getStringExtra(EXTRA_NAME_ACCOUNT).toString()
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        mBinding.account = mAccount

        mProfileVM = ViewModelProvider(this,
            ProfileVMFactory(ApiHelper(RetrofitBuilder.apiService)))[ProfileVM::class.java]

        // Observe
        mProfileVM.followerListModel.observe(this) {

        }

        mProfileVM.profileModel.observe(this) {
            mBinding.stateView.profile = it?.value
        }

        getProfile(mAccount)
    }

    private fun getFollower(account: String) {
        mProfileVM.getFollowerList(this, account)
    }

    private fun getProfile(account: String) {
        mProfileVM.getProfile(this, account)
    }

}

@BindingAdapter("setAvatar")
fun ShapeableImageView.setAvatar(url: String?) {
    Glide.with(this.context).load(url).into(this)
}