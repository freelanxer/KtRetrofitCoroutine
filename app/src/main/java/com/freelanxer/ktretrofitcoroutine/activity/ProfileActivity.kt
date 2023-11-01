package com.freelanxer.ktretrofitcoroutine.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.freelanxer.ktretrofitcoroutine.R
import com.freelanxer.ktretrofitcoroutine.databinding.ActivityProfileBinding

class ProfileActivity: BaseActivity() {
    companion object {
        const val EXTRA_NAME_ACCOUNT = "EXTRA_NAME_ACCOUNT"
    }
    private lateinit var mBinding: ActivityProfileBinding
    private lateinit var mAccount: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAccount = intent.getStringExtra(EXTRA_NAME_ACCOUNT).toString()
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        mBinding.account = mAccount
    }
}