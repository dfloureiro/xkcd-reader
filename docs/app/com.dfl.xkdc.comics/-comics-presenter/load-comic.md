[app](../../index.md) / [com.dfl.xkdc.comics](../index.md) / [ComicsPresenter](index.md) / [loadComic](./load-comic.md)

# loadComic

`fun loadComic(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

loads comic to display
if no valid id present, loads latest from network
if valid id present, and in the comic repository, loads from repository
if valid id present, and not in the comic repository, loads from network

