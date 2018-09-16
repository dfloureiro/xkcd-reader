[app](../../index.md) / [com.dfl.xkdc.schedulers](../index.md) / [RxSchedulers](./index.md)

# RxSchedulers

`interface RxSchedulers`

Rx Schedulers to subscribe on

### Functions

| Name | Summary |
|---|---|
| [computation](computation.md) | `abstract fun computation(): Scheduler`<br>scheduler computation work |
| [io](io.md) | `abstract fun io(): Scheduler`<br>scheduler input output |
| [mainThread](main-thread.md) | `abstract fun mainThread(): Scheduler`<br>scheduler UI thread |

### Inheritors

| Name | Summary |
|---|---|
| [RxSchedulersImpl](../-rx-schedulers-impl/index.md) | `class RxSchedulersImpl : `[`RxSchedulers`](./index.md) |
