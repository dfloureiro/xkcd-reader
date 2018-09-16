package com.dfl.xkdc.loader

import android.widget.ImageView
import com.dfl.xkdc.R
import com.squareup.picasso.Picasso

/**
 * loads images
 * @param picasso lib to load images
 */
class ImageLoader(private val picasso: Picasso) {

    /**
     * loads image from url to image view
     * @param url url to load from
     * @param imageView view to load image into
     */
    fun load(url: String, imageView: ImageView) {
        picasso.load(url).placeholder(R.mipmap.ic_launcher).into(imageView)
    }
}