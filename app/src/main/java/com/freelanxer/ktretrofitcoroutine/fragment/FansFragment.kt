package com.freelanxer.ktretrofitcoroutine.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freelanxer.ktretrofitcoroutine.databinding.FragmentFansBinding

class FansFragment: BaseFragment() {
    private lateinit var mBinding: FragmentFansBinding

    companion object {
        fun newInstance(): FansFragment {
            val fragment = FansFragment()
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
        mBinding = FragmentFansBinding.inflate(inflater)
        mBinding.lifecycleOwner = this

        return mBinding.root
    }

    override fun onClick(view: View?) {
        super.onClick(view)
    }

}