package com.dfl.xkdc.comics

/**
 * Presenter to handle fav options with comics
 */
interface ComicFavPresenter {

    /**
     * fav comic
     * @param id of the comic to fav
     */
    fun favComic(id: Int)

    /**
     * unFav comic
     * @param id of the comic to unFav
     */
    fun unFavComic(id: Int)
}