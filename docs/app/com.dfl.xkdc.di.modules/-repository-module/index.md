[app](../../index.md) / [com.dfl.xkdc.di.modules](../index.md) / [RepositoryModule](./index.md)

# RepositoryModule

`class RepositoryModule`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RepositoryModule(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)` |

### Functions

| Name | Summary |
|---|---|
| [providedComicsRepository](provided-comics-repository.md) | `fun providedComicsRepository(dao: `[`ComicsDao`](../../com.dfl.xkdc.repository/-comics-dao/index.md)`): `[`ComicsRepository`](../../com.dfl.xkdc.repository/-comics-repository/index.md) |
| [providesComicsDao](provides-comics-dao.md) | `fun providesComicsDao(): `[`ComicsDao`](../../com.dfl.xkdc.repository/-comics-dao/index.md) |
| [providesComicsInteractor](provides-comics-interactor.md) | `fun providesComicsInteractor(services: `[`XkcdServices`](../../com.dfl.xkdc.network/-xkcd-services/index.md)`, repository: `[`ComicsRepository`](../../com.dfl.xkdc.repository/-comics-repository/index.md)`, mapper: `[`ComicsMapper`](../../com.dfl.xkdc.mapper/-comics-mapper/index.md)`): `[`ComicsInteractor`](../../com.dfl.xkdc.interactor/-comics-interactor/index.md) |
| [providesComicsMapper](provides-comics-mapper.md) | `fun providesComicsMapper(): `[`ComicsMapper`](../../com.dfl.xkdc.mapper/-comics-mapper/index.md) |
