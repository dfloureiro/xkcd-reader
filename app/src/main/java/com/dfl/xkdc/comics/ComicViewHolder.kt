package com.dfl.xkdc.comics

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.dfl.xkdc.R
import com.dfl.xkdc.loader.ImageLoader
import com.like.LikeButton
import com.like.OnLikeListener


class ComicViewHolder(itemView: View?, private val imageLoader: ImageLoader, private val favPresenter: ComicFavPresenter) : RecyclerView.ViewHolder(itemView) {

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

    fun setId(id: Int) {
        itemView.findViewById<LikeButton>(R.id.comicLike).setOnLikeListener(object : OnLikeListener {
            override fun liked(likeButton: LikeButton) {
                favPresenter.favComic(id)
            }

            override fun unLiked(likeButton: LikeButton) {
                favPresenter.unFavComic(id)
            }
        })
    }
}
