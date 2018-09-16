[app](../../index.md) / [com.dfl.xkdc.comics](../index.md) / [ComicsAdapter](./index.md)

# ComicsAdapter

`class ComicsAdapter : Adapter<`[`ComicViewHolder`](../-comic-view-holder/index.md)`>`

comics adapter do display all comics

### Parameters

`comics` - list of comics

`imageLoader` - loads images

`comicFavPresenter` - handles fav options for comics

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ComicsAdapter(comics: `[`ArrayList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/index.html)`<`[`Comic`](../../com.dfl.xkdc.uimodel/-comic/index.md)`>, imageLoader: `[`ImageLoader`](../../com.dfl.xkdc.loader/-image-loader/index.md)`, comicFavPresenter: `[`ComicFavPresenter`](../-comic-fav-presenter/index.md)`)`<br>comics adapter do display all comics |

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `fun add(comic: `[`Comic`](../../com.dfl.xkdc.uimodel/-comic/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>add comic to adapter |
| [getItemCount](get-item-count.md) | `fun getItemCount(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: `[`ComicViewHolder`](../-comic-view-holder/index.md)`, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ComicViewHolder`](../-comic-view-holder/index.md) |
| [remove](remove.md) | `fun remove(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>removes comic from adapter |
