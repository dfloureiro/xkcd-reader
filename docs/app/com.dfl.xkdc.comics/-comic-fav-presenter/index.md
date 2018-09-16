[app](../../index.md) / [com.dfl.xkdc.comics](../index.md) / [ComicFavPresenter](./index.md)

# ComicFavPresenter

`interface ComicFavPresenter`

Presenter to handle fav options with comics

### Functions

| Name | Summary |
|---|---|
| [favComic](fav-comic.md) | `abstract fun favComic(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>fav comic |
| [unFavComic](un-fav-comic.md) | `abstract fun unFavComic(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>unFav comic |

### Inheritors

| Name | Summary |
|---|---|
| [ComicsPresenter](../-comics-presenter/index.md) | `class ComicsPresenter : `[`ComicFavPresenter`](./index.md)<br>Presenter that handles all interactions with comics |
