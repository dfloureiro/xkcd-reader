[app](../../index.md) / [com.dfl.xkdc.network](../index.md) / [XkcdServices](index.md) / [getComic](./get-comic.md)

# getComic

`@GET("/{id}/info.0.json") abstract fun getComic(@Path("id") id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Single<`[`ComicResponse`](../../com.dfl.xkdc.model/-comic-response/index.md)`>`

get comic from id

### Parameters

`id` - id of the comic to retrieve

**Return**
single to retrieve comic

`@GET("/info.0.json") abstract fun getComic(): Single<`[`ComicResponse`](../../com.dfl.xkdc.model/-comic-response/index.md)`>`

get latest comic

**Return**
single to retrieve comic

