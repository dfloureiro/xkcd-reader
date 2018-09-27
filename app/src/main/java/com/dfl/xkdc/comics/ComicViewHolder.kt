package com.dfl.xkdc.comics

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.dfl.xkdc.R
import com.dfl.xkdc.loader.ImageLoader
import com.like.LikeButton
import com.like.OnLikeListener

/**
 * View holder for comic items
 * @param itemView base view
 * @param imageLoader loads images from url into view
 * @param favPresenter fav and UnFav comics by id
 */
class ComicViewHolder(itemView: View, private val imageLoader: ImageLoader, private val favPresenter: ComicFavPresenter) : RecyclerView.ViewHolder(itemView) {

    /**
     * set comic image
     * @param url comic image's url
     */
    fun setImage(url: String) {
        imageLoader.load(url, itemView.findViewById(R.id.comicImage)
        )
    }

    /**
     * set comic title
     * @param title comic's title
     */
    fun setTitle(title: String) {
        itemView.findViewById<TextView>(R.id.comicTitle).text = title
    }

    /**
     * set comic description
     * @param description comic's description
     */
    fun setDescription(description: String) {
        itemView.findViewById<TextView>(R.id.comicDescription).text = description
    }

    /**
     * set comic number
     * set comic id and like button listener
     * when liked fav comic
     * when unLiked unFav comic
     */
    fun setId(id: Int) {
        val number = "#$id"
        itemView.findViewById<TextView>(R.id.comicNumber).text = number
        itemView.findViewById<LikeButton>(R.id.comicLike).setOnLikeListener(object : OnLikeListener {
            override fun liked(likeButton: LikeButton) {
                favPresenter.favComic(id)
            }

            override fun unLiked(likeButton: LikeButton) {
                favPresenter.unFavComic(id)
            }
        })
    }

    /**
     * set comic like button
     * @param isFav if true button is liked
     */
    fun setFav(isFav: Boolean) {
        itemView.findViewById<LikeButton>(R.id.comicLike).isLiked = isFav
    }
}
