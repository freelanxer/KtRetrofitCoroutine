package com.freelanxer.ktretrofitcoroutine.adapter.post

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.freelanxer.ktretrofitcoroutine.databinding.ListItemPostGridBinding
import com.freelanxer.ktretrofitcoroutine.model.post.PostModel

class PostGridAdapter: RecyclerView.Adapter<PostGridAdapter.ViewHolder>() {
    private var mData: List<PostModel>? = null

    fun setData(list: List<PostModel>?) {
        mData = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemPostGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mData?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = mData?.get(position)
        holder.bind(post)
    }

    inner class ViewHolder(
        private val binding: ListItemPostGridBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostModel?) {
            binding.post = item
            binding.executePendingBindings()
        }
    }

}

@BindingAdapter("setPostThumb")
fun ImageView.setPostThumb(url: String?) {
    Glide.with(this.context).load(url).into(this)
}