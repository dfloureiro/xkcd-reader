[app](../../index.md) / [com.dfl.xkdc.repository](../index.md) / [ComicsDao](./index.md)

# ComicsDao

`interface ComicsDao`

comics dao

### Functions

| Name | Summary |
|---|---|
| [favComic](fav-comic.md) | `abstract fun favComic(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>update comic as fav |
| [getComic](get-comic.md) | `abstract fun getComic(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Single<`[`ComicEntity`](../-comic-entity/index.md)`>`<br>get comic |
| [getFavourites](get-favourites.md) | `abstract fun getFavourites(): Flowable<`[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`ComicEntity`](../-comic-entity/index.md)`>>`<br>get all comics with fav |
| [insert](insert.md) | `abstract fun insert(comic: `[`ComicEntity`](../-comic-entity/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>insert comic |
| [unFavComic](un-fav-comic.md) | `abstract fun unFavComic(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>update comic as unFav |
