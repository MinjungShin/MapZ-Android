package com.cheocharm.presentation.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingAdapters {

    @BindingAdapter("app:imageLoad")
    @JvmStatic
    fun loadImage(itemView: ImageView, url: String?) {
        url ?: return
        Glide.with(itemView).load(url)
            .into(itemView)
    }

    @BindingAdapter("app:imageCircledLoad")
    @JvmStatic
    fun loadCircleImage(itemView: ImageView, url: String?) {
        url ?: return
        Glide.with(itemView).load(url).circleCrop()
            .into(itemView)
    }
}
