package com.dfl.xkdc.schedulers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RxSchedulersImpl : RxSchedulers {
    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun mainThread(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

}