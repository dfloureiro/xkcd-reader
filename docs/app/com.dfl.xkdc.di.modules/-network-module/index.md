[app](../../index.md) / [com.dfl.xkdc.di.modules](../index.md) / [NetworkModule](./index.md)

# NetworkModule

`class NetworkModule`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NetworkModule()` |

### Functions

| Name | Summary |
|---|---|
| [provideGsonConverterFactory](provide-gson-converter-factory.md) | `fun provideGsonConverterFactory(): MoshiConverterFactory` |
| [provideOkHttpClient](provide-ok-http-client.md) | `fun provideOkHttpClient(): OkHttpClient` |
| [provideRxJava2CallAdapterFactory](provide-rx-java2-call-adapter-factory.md) | `fun provideRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory` |
| [provideXkcdServices](provide-xkcd-services.md) | `fun provideXkcdServices(okHttpClient: OkHttpClient, callAdapterFactory: RxJava2CallAdapterFactory, moshiConverterFactory: MoshiConverterFactory): `[`XkcdServices`](../../com.dfl.xkdc.network/-xkcd-services/index.md) |
