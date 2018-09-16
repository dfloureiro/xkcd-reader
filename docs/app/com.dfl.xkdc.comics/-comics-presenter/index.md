[app](../../index.md) / [com.dfl.xkdc.comics](../index.md) / [ComicsPresenter](./index.md)

# ComicsPresenter

`class ComicsPresenter : `[`ComicFavPresenter`](../-comic-fav-presenter/index.md)

Presenter that handles all interactions with comics

### Parameters

`view` - fragment view

`interactor` - interactor to interact with local repository and network

`rxSchedulers` - schedulers to subscribe on

`compositeDisposable` - add and dispose disposables

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ComicsPresenter(view: `[`ComicsFragment`](../-comics-fragment/index.md)`, interactor: `[`ComicsInteractor`](../../com.dfl.xkdc.interactor/-comics-interactor/index.md)`, rxSchedulers: `[`RxSchedulers`](../../com.dfl.xkdc.schedulers/-rx-schedulers/index.md)`, compositeDisposable: CompositeDisposable)`<br>Presenter that handles all interactions with comics |

### Properties

| Name | Summary |
|---|---|
| [latestComicId](latest-comic-id.md) | `var latestComicId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [favComic](fav-comic.md) | `fun favComic(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>set comic as fav |
| [loadComic](load-comic.md) | `fun loadComic(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>loads comic to display if no valid id present, loads latest from network if valid id present, and in the comic repository, loads from repository if valid id present, and not in the comic repository, loads from network |
| [subscribe](subscribe.md) | `fun subscribe(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>subscribe the presenter initial tasks |
| [unFavComic](un-fav-comic.md) | `fun unFavComic(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>set comic as unFav |
| [unsubscribe](unsubscribe.md) | `fun unsubscribe(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>disposes all disposables |
