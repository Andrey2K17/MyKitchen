package com.pg13.mycitchen.ui.base

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load

object BindingUtils {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun ImageView.bindImage(imageUrl: String?) {
        imageUrl?.let {
            val imgUri = imageUrl.toUri().buildUpon().scheme("https").build()
            load(imgUri)
        }
    }
}