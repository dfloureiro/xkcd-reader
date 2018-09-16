[app](../../index.md) / [com.dfl.xkdc.di.modules](../index.md) / [ComicsModule](./index.md)

# ComicsModule

`class ComicsModule`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ComicsModule(comicsFragment: `[`ComicsFragment`](../../com.dfl.xkdc.comics/-comics-fragment/index.md)`)` |

### Functions

| Name | Summary |
|---|---|
| [providesComicsAdapter](provides-comics-adapter.md) | `fun providesComicsAdapter(imageLoader: `[`ImageLoader`](../../com.dfl.xkdc.loader/-image-loader/index.md)`, presenter: `[`ComicsPresenter`](../../com.dfl.xkdc.comics/-comics-presenter/index.md)`): `[`ComicsAdapter`](../../com.dfl.xkdc.comics/-comics-adapter/index.md) |
| [providesComicsPresenter](provides-comics-presenter.md) | `fun providesComicsPresenter(interactor: `[`ComicsInteractor`](../../com.dfl.xkdc.interactor/-comics-interactor/index.md)`, rxSchedulers: `[`RxSchedulers`](../../com.dfl.xkdc.schedulers/-rx-schedulers/index.md)`, compositeDisposable: CompositeDisposable): `[`ComicsPresenter`](../../com.dfl.xkdc.comics/-comics-presenter/index.md) |
| [providesCompositeDisposable](provides-composite-disposable.md) | `fun providesCompositeDisposable(): CompositeDisposable` |
