package com.dfl.xkdc.mapper

import com.dfl.xkdc.uimodel.Comic
import com.dfl.xkdc.repository.ComicEntity
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
