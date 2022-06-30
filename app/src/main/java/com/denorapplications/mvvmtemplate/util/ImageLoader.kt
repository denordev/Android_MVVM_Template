package com.denorapplications.mvvmtemplate.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.denorapplications.mvvmtemplate.R
import javax.inject.Inject

class ImageLoader @Inject constructor(
    private val context: Context
) {

    private val glide = Glide.with(context)

    fun loadImage(imageData: Any, view: ImageView) {
        glide.load(imageData)
            .centerCrop()
            .placeholder(R.drawable.animation)
            .error(R.drawable.ic_baseline_error_outline_24)
            .into(view);
    }
}
