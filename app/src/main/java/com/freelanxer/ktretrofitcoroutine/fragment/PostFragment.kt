package com.freelanxer.ktretrofitcoroutine.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.freelanxer.ktretrofitcoroutine.adapter.post.PostGridAdapter
import com.freelanxer.ktretrofitcoroutine.databinding.FragmentPostBinding
import com.freelanxer.ktretrofitcoroutine.network.ApiHelper
import com.freelanxer.ktretrofitcoroutine.network.RetrofitBuilder
import com.freelanxer.ktretrofitcoroutine.viewmodel.PostGridVM
import com.freelanxer.ktretrofitcoroutine.viewmodel.PostVMFactory

class PostFragment: BaseFragment() {
    private lateinit var mBinding: FragmentPostBinding
    private lateinit var mPostVM: PostGridVM
    private val mPostAdapter: PostGridAdapter by lazy {
        PostGridAdapter()
    }

    companion object {
        fun newInstance(): PostFragment {
            val fragment = PostFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPostVM = ViewModelProvider(this,
            PostVMFactory(ApiHelper(RetrofitBuilder.apiService)))[PostGridVM::class.java]

        mPostVM.postListModel.observe(this) {
            val model = it?.value
            val postList = model?.postList
            mPostAdapter.setData(postList)
        }

        getPostList()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentPostBinding.inflate(inflater)
        mBinding.lifecycleOwner = this

        mBinding.postGridRv.setHasFixedSize(true)
        mBinding.postGridRv.layoutManager = GridLayoutManager(mBaseActivity, 3)
        mBinding.postGridRv.adapter = mPostAdapter
        mBinding.swipeLayout.setOnRefreshListener {
            getPostList()
            mBinding.swipeLayout.isRefreshing = false
        }

        return mBinding.root
    }

    private fun getPostList() {
        mPostVM.getPostList(this, "");
    }

    override fun onClick(view: View?) {
        super.onClick(view)
    }

}