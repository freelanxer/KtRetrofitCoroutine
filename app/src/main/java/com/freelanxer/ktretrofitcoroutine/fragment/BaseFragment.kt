package com.freelanxer.ktretrofitcoroutine.fragment

import android.content.Context
import android.view.View
import android.view.View.OnClickListener
import androidx.fragment.app.Fragment
import com.freelanxer.ktretrofitcoroutine.activity.BaseActivity

open abstract class BaseFragment: Fragment(), OnClickListener {
    protected lateinit var mBaseActivity: BaseActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            mBaseActivity = context
        }
    }

    override fun onClick(view: View?) {

    }

}