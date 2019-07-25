package com.isaac.randomparrot.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class GlideBindingAdapter {
    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun setImageUrl(view: ImageView, parrotPath: String?) {
            Glide
                .with(view.context)
                .load("https://cultofthepartyparrot.com/parrots/$parrotPath")
                .into(view)
        }
    }
}