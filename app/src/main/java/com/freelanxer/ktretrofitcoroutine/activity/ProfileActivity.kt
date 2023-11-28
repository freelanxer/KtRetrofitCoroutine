package com.freelanxer.ktretrofitcoroutine.activity

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.freelanxer.ktretrofitcoroutine.R
import com.freelanxer.ktretrofitcoroutine.databinding.ActivityProfileBinding
import com.freelanxer.ktretrofitcoroutine.fragment.FansFragment
import com.freelanxer.ktretrofitcoroutine.fragment.FollowerFragment
import com.freelanxer.ktretrofitcoroutine.fragment.PostFragment
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
    private var mFragment: Fragment? = null

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

        mBinding.stateView.postLl.setOnClickListener(this)
        mBinding.stateView.fansLl.setOnClickListener(this)
        mBinding.stateView.followerLl.setOnClickListener(this)

        getProfile(mAccount)

        //Set default fragment
        mBinding.stateView.postSelected = true
        navigateFragment(PostFragment.newInstance())
    }

    private fun getFollower(account: String) {
        mProfileVM.getFollowerList(this, account)
    }

    private fun getProfile(account: String) {
        mProfileVM.getProfile(this, account)
    }

    private fun navigateFragment(fragment: Fragment) {
        if (mFragment?.javaClass == fragment.javaClass)
            return
        mFragment = fragment
        val fragmentTransient = supportFragmentManager.beginTransaction()
        fragmentTransient.replace(R.id.profile_fl, fragment)
        fragmentTransient.commit()
    }

    private fun onStateItemSelect(selectedView: View) {
        mBinding.stateView.postSelected = selectedView.id == R.id.post_ll
        mBinding.stateView.fansSelected = selectedView.id == R.id.fans_ll
        mBinding.stateView.followerSelected = selectedView.id == R.id.follower_ll
        var fragment = when (selectedView.id) {
            R.id.post_ll -> PostFragment.newInstance()
            R.id.fans_ll -> FansFragment.newInstance()
            R.id.follower_ll -> FollowerFragment.newInstance()
            else -> PostFragment.newInstance()
        }
        navigateFragment(fragment)
    }

    override fun onClick(view: View?) {
        super.onClick(view)
        if (view == null)
            return
        val selectId = view.id
        if (selectId == R.id.post_ll
            || selectId == R.id.fans_ll
            || selectId == R.id.follower_ll) {
            onStateItemSelect(view)
        }
    }

}

@BindingAdapter("setAvatar")
fun ShapeableImageView.setAvatar(url: String?) {
    Glide.with(this.context).load(url).into(this)
}

@BindingAdapter("isBold")
fun TextView.isBold(isBold: Boolean) {
    if (isBold) {
        setTypeface(null, Typeface.BOLD)
    } else {
        setTypeface(null, Typeface.NORMAL)
    }
}