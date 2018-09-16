[app](../../index.md) / [com.dfl.xkdc.interactor](../index.md) / [ComicsInteractor](./index.md)

# ComicsInteractor

`class ComicsInteractor`

interactor to handle interactions with comics

### Parameters

`service` - handle comic network requests

`repository` - repository to save comics

`mapper` - maps comics objects

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ComicsInteractor(service: `[`XkcdServices`](../../com.dfl.xkdc.network/-xkcd-services/index.md)`, repository: `[`ComicsRepository`](../../com.dfl.xkdc.repository/-comics-repository/index.md)`, mapper: `[`ComicsMapper`](../../com.dfl.xkdc.mapper/-comics-mapper/index.md)`)`<br>interactor to handle interactions with comics |

### Functions

| Name | Summary |
|---|---|
| [favComic](fav-comic.md) | `fun favComic(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Completable` |
| [getComicNetwork](get-comic-network.md) | `fun getComicNetwork(): Single<`[`Comic`](../../com.dfl.xkdc.uimodel/-comic/index.md)`>`<br>`fun getComicNetwork(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Single<`[`Comic`](../../com.dfl.xkdc.uimodel/-comic/index.md)`>` |
| [getComicRepository](get-comic-repository.md) | `fun getComicRepository(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Single<`[`Comic`](../../com.dfl.xkdc.uimodel/-comic/index.md)`>` |
| [getFavourites](get-favourites.md) | `fun getFavourites(): Flowable<`[`Comic`](../../com.dfl.xkdc.uimodel/-comic/index.md)`>` |
| [insertComic](insert-comic.md) | `fun insertComic(comic: `[`Comic`](../../com.dfl.xkdc.uimodel/-comic/index.md)`): Completable` |
| [unFavComic](un-fav-comic.md) | `fun unFavComic(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Completable` |
