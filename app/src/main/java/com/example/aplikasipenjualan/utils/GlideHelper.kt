package com.example.aplikasipenjualan.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.aplikasipenjualan.R

class GlideHelper {

    companion object {
        fun setImage(context: Context, urlImage: String, imageView: ImageView){
            Glide.with(context)
                    .load(urlImage)
                    .centerCrop()
                    .placeholder(R.drawable.img_no_image)
                    .error(R.drawable.img_no_image)
                    .into(imageView)
        }
    }
}