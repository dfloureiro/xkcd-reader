package com.dfl.xkdc.comics

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.dfl.xkdc.R
import com.dfl.xkdc.loaders.ImageLoader

class ComicViewHolder(itemView: View?, private val imageLoader: ImageLoader) : RecyclerView.ViewHolder(itemView) {

    fun setImage(url: String) {
        imageLoader.load(url, itemView.findViewById(R.id.comicImage)
        )
    }

    fun setTitle(title: String) {
        itemView.findViewById<TextView>(R.id.comicTitle).text = title
    }

    fun setDescription(description: String) {
        itemView.findViewById<TextView>(R.id.comicDescription).text = description
    }
}
