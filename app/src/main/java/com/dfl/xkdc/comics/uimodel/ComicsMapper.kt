package com.dfl.xkdc.comics.uimodel

import com.dfl.xkdc.database.ComicEntity
import com.dfl.xkdc.model.ComicResponse

class ComicsMapper {

    fun convert(comicResponse: ComicResponse): Comic {
        return Comic(comicResponse.num, comicResponse.title, comicResponse.img, comicResponse.alt, false)
    }

    fun convert(comicEntity: ComicEntity): Comic {
        return Comic(comicEntity.id, comicEntity.title, comicEntity.imageUrl, comicEntity.alt, comicEntity.fav)
    }

    fun convert(comic: Comic): ComicEntity {
        return ComicEntity(comic.id, comic.title, comic.url, comic.description, comic.isFav)
    }
}
