[app](../../index.md) / [com.dfl.xkdc.comics](../index.md) / [ComicViewHolder](./index.md)

# ComicViewHolder

`class ComicViewHolder : ViewHolder`

View holder for comic items

### Parameters

`itemView` - base view

`imageLoader` - loads images from url into view

`favPresenter` - fav and UnFav comics by id

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ComicViewHolder(itemView: `[`View`](https://developer.android.com/reference/android/view/View.html)`?, imageLoader: `[`ImageLoader`](../../com.dfl.xkdc.loader/-image-loader/index.md)`, favPresenter: `[`ComicFavPresenter`](../-comic-fav-presenter/index.md)`)`<br>View holder for comic items |

### Functions

| Name | Summary |
|---|---|
| [setDescription](set-description.md) | `fun setDescription(description: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>set comic description |
| [setId](set-id.md) | `fun setId(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>set comic id and like button listener when liked fav comic when unLiked unFav comic |
| [setImage](set-image.md) | `fun setImage(url: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>set comic image |
| [setTitle](set-title.md) | `fun setTitle(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>set comic title |
