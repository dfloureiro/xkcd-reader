[app](../../index.md) / [com.dfl.xkdc.di.components](../index.md) / [XkcdComponent](./index.md)

# XkcdComponent

`@Component([XkcdModule, RepositoryModule]) @Singleton interface XkcdComponent`

### Functions

| Name | Summary |
|---|---|
| [comicsInteractor](comics-interactor.md) | `abstract fun comicsInteractor(): `[`ComicsInteractor`](../../com.dfl.xkdc.interactor/-comics-interactor/index.md) |
| [imageLoader](image-loader.md) | `abstract fun imageLoader(): `[`ImageLoader`](../../com.dfl.xkdc.loader/-image-loader/index.md) |
| [inject](inject.md) | `abstract fun inject(application: `[`XkcdApplication`](../../com.dfl.xkdc/-xkcd-application/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [rxSchedulers](rx-schedulers.md) | `abstract fun rxSchedulers(): `[`RxSchedulers`](../../com.dfl.xkdc.schedulers/-rx-schedulers/index.md) |
