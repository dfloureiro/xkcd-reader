package com.dfl.xkdc.comics

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dfl.xkdc.R
import com.dfl.xkdc.loader.ImageLoader
import com.dfl.xkdc.uimodel.Comic

/**
 * comics adapter do display all comics
 * @param comics list of comics
 * @param imageLoader loads images
 * @param comicFavPresenter handles fav options for comics
 */
class ComicsAdapter(private val comics: ArrayList<Comic>, private val imageLoader: ImageLoader, private val comicFavPresenter: ComicFavPresenter) : RecyclerView.Adapter<ComicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        return ComicViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.comic_item, parent, false), imageLoader, comicFavPresenter)
    }

    override fun getItemCount(): Int {
        return comics.size
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        comics[position].also {
            holder.setImage(it.url)
            holder.setTitle(it.title)
            holder.setDescription(it.description)
            holder.setId(it.id)
            holder.setFav(it.isFav)
        }
    }

    /**
     * add comic to adapter
     * @param comic comic to add
     */
    fun add(comic: Comic) {
        comics.add(comic)
        notifyItemInserted(itemCount)
    }

    /**
     * removes comic from adapter
     * @param index position of the comic to remove
     */
    fun remove(index: Int) {
        comics.removeAt(index)
        notifyItemRemoved(index)
    }
}