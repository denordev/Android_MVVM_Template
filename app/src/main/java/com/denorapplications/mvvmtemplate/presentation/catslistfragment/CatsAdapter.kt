package com.denorapplications.mvvmtemplate.presentation.catslistfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.denorapplications.mvvmtemplate.databinding.ItemCatBinding
import com.denorapplications.mvvmtemplate.domain.models.Cat
import com.denorapplications.mvvmtemplate.util.ImageLoader

class CatsAdapter : ListAdapter<Cat, CatViewHolder>(DiffCallback) {

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.onBind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(
            ItemCatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Cat>() {

            override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}

class CatViewHolder(
    private val binding: ItemCatBinding
) : RecyclerView.ViewHolder(binding.root) {

    private val imageLoader = ImageLoader(binding.root.context)

    fun onBind(cat: Cat) = with(binding) {
        imageLoader.loadImage(cat.url, catImage)
    }
}
