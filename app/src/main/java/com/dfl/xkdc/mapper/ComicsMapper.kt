package com.dfl.xkdc.mapper

import com.dfl.xkdc.model.ComicResponse
import com.dfl.xkdc.repository.ComicEntity
import com.dfl.xkdc.uimodel.Comic

/**
 * maps comics
 */
class ComicsMapper {

    /**
     * map comicResponse into Comic
     * @param comicResponse response to map
     */
    fun convert(comicResponse: ComicResponse): Comic {
        return Comic(comicResponse.num, comicResponse.title, comicResponse.img, comicResponse.alt, false)
    }

    /**
     * map comicEntity into Comic
     * @param comicEntity entity to map
     */
    fun convert(comicEntity: ComicEntity): Comic {
        return Comic(comicEntity.id, comicEntity.title, comicEntity.imageUrl, comicEntity.alt, comicEntity.fav)
    }

    /**
     * map comic into ComicEntity
     * @param comic comic to map
     */
    fun convert(comic: Comic): ComicEntity {
        return ComicEntity(comic.id, comic.title, comic.url, comic.description, comic.isFav)
    }
}
