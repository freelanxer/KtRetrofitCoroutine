package com.freelanxer.ktretrofitcoroutine.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.freelanxer.ktretrofitcoroutine.R
import com.freelanxer.ktretrofitcoroutine.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private val profileLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

    }

    private fun getAccount() = mBinding.accountEt.text.toString()

    private fun greeting(account: String?) {
        if (TextUtils.isEmpty(account))
            return
        val greeting = String.format(getString(R.string.sign_in_greeting), account)
        showToast(greeting)
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        if (view == mBinding.goBtn) {
            val account = getAccount()
            greeting(account)
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra(ProfileActivity.EXTRA_NAME_ACCOUNT, account)
            profileLauncher.launch(intent)
        }
    }

}