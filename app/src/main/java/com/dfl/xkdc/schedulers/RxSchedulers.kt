package com.dfl.xkdc.schedulers

import io.reactivex.Scheduler

interface RxSchedulers {

    fun io(): Scheduler

    fun computation(): Scheduler

    fun mainThread(): Scheduler
}