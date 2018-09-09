package com.dfl.xkdc.comics.uimodel

import com.dfl.xkdc.model.ComicResponse

class ComicsMapper {

    fun convert(comicResponse: ComicResponse): Comic {
        return Comic(comicResponse.title, comicResponse.img, comicResponse.alt)
    }
}
