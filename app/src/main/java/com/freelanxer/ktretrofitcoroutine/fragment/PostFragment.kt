package com.freelanxer.ktretrofitcoroutine.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.freelanxer.ktretrofitcoroutine.adapter.post.PostGridAdapter
import com.freelanxer.ktretrofitcoroutine.databinding.FragmentPostBinding
import com.freelanxer.ktretrofitcoroutine.model.post.PostModel

class PostFragment: BaseFragment() {
    private lateinit var mBinding: FragmentPostBinding
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

        createPost()
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

        return mBinding.root
    }

    private fun createPost() {
        val postList = mutableListOf<PostModel>()
        for (i in 0..10) {
            val post = PostModel(
                "Id_$i",
                "this is caption",
                "https://www.kkday.com/zh-tw/blog/wp-content/uploads/batch_Fotolia_76642429_Subscription_Yearly_M-2.jpg",
                5,
                "20230506",
                4
            )
            postList.add(post)
        }
        mPostAdapter.setData(postList)
    }

    override fun onClick(view: View?) {
        super.onClick(view)
    }

}