package com.dfl.xkdc.schedulers

import io.reactivex.Scheduler

/**
 * Rx Schedulers to subscribe on
 */
interface RxSchedulers {

    /**
     * scheduler input output
     */
    fun io(): Scheduler

    /**
     * scheduler computation work
     */
    fun computation(): Scheduler

    /**
     * scheduler UI thread
     */
    fun mainThread(): Scheduler
}