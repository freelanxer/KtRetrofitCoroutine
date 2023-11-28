package com.freelanxer.ktretrofitcoroutine.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freelanxer.ktretrofitcoroutine.databinding.FragmentFollowerBinding

class FollowerFragment: BaseFragment() {
    private lateinit var mBinding: FragmentFollowerBinding

    companion object {
        fun newInstance(): FollowerFragment {
            val fragment = FollowerFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFollowerBinding.inflate(inflater)
        mBinding.lifecycleOwner = this

        return mBinding.root
    }

    override fun onClick(view: View?) {
        super.onClick(view)
    }

}