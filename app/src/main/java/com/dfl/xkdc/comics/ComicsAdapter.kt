package com.dfl.xkdc.comics

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dfl.xkdc.R
import com.dfl.xkdc.comics.uimodel.Comic
import com.dfl.xkdc.loaders.ImageLoader

class ComicsAdapter(private val comics: ArrayList<Comic>, private val imageLoader: ImageLoader) : RecyclerView.Adapter<ComicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        return ComicViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.comic_item, parent, false), imageLoader)
    }

    override fun getItemCount(): Int {
        return comics.size
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        comics[position].also {
            holder.setImage(it.url)
            holder.setTitle(it.title)
            holder.setDescription(it.description)
        }
    }

    fun add(comic: Comic) {
        comics.add(comic)
        notifyItemInserted(itemCount)
    }

    fun remove(index: Int) {
        comics.removeAt(index)
        notifyItemRemoved(index)
    }
}