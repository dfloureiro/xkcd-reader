package com.dfl.xkdc.loaders

import android.widget.ImageView
import com.dfl.xkdc.R
import com.squareup.picasso.Picasso


class ImageLoader(private val picasso: Picasso) {

    fun load(url: String, imageView: ImageView) {
        picasso.load(url).placeholder(R.mipmap.ic_launcher).into(imageView)
    }
}