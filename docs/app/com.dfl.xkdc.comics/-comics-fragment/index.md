[app](../../index.md) / [com.dfl.xkdc.comics](../index.md) / [ComicsFragment](./index.md)

# ComicsFragment

`class ComicsFragment : Fragment`

Fragment that displays all comics

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ComicsFragment()`<br>Fragment that displays all comics |

### Properties

| Name | Summary |
|---|---|
| [adapter](adapter.md) | `lateinit var adapter: `[`ComicsAdapter`](../-comics-adapter/index.md) |
| [isLoading](is-loading.md) | `var isLoading: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [presenter](presenter.md) | `lateinit var presenter: `[`ComicsPresenter`](../-comics-presenter/index.md) |

### Functions

| Name | Summary |
|---|---|
| [hideProgress](hide-progress.md) | `fun hideProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onAttach](on-attach.md) | `fun onAttach(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`, container: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`View`](https://developer.android.com/reference/android/view/View.html)`?` |
| [onDestroy](on-destroy.md) | `fun onDestroy(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onViewCreated](on-view-created.md) | `fun onViewCreated(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>sets recycler view and scroll listener subscribes presenter |
| [remove](remove.md) | `fun remove(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>remove comic in adapter |
| [show](show.md) | `fun show(comic: `[`Comic`](../../com.dfl.xkdc.uimodel/-comic/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>show comic in adapter |
| [showProgress](show-progress.md) | `fun showProgress(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [newInstance](new-instance.md) | `fun newInstance(): `[`ComicsFragment`](./index.md) |
