package com.freelanxer.ktretrofitcoroutine.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.freelanxer.ktretrofitcoroutine.R
import com.freelanxer.ktretrofitcoroutine.databinding.ActivityProfileBinding
import com.freelanxer.ktretrofitcoroutine.network.ApiHelper
import com.freelanxer.ktretrofitcoroutine.network.RetrofitBuilder
import com.freelanxer.ktretrofitcoroutine.viewmodel.ProfileVM
import com.freelanxer.ktretrofitcoroutine.viewmodel.ProfileVMFactory

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

        mProfileVM.followerListModel.observe(this) {

        }

        getFollower(mAccount)
    }

    private fun getFollower(account: String) {
        mProfileVM.getFollowerList(this, account)
    }
}