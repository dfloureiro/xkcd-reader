[app](../../index.md) / [com.dfl.xkdc.repository](../index.md) / [ComicsRepository](./index.md)

# ComicsRepository

`class ComicsRepository`

comics repository

### Parameters

`dao` - comics database

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ComicsRepository(dao: `[`ComicsDao`](../-comics-dao/index.md)`)`<br>comics repository |

### Functions

| Name | Summary |
|---|---|
| [favComic](fav-comic.md) | `fun favComic(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Completable`<br>update entity as fav |
| [getComic](get-comic.md) | `fun getComic(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Single<`[`ComicEntity`](../-comic-entity/index.md)`>`<br>retrieve entity |
| [getFavourites](get-favourites.md) | `fun getFavourites(): Flowable<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ComicEntity`](../-comic-entity/index.md)`>>`<br>retrieve all entities with fav |
| [insert](insert.md) | `fun insert(comic: `[`ComicEntity`](../-comic-entity/index.md)`): Completable`<br>insert entity |
| [unFavComic](un-fav-comic.md) | `fun unFavComic(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Completable`<br>update entity as unFav |
