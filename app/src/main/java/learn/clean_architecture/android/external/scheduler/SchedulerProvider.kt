package learn.clean_architecture.android.external.scheduler

import io.reactivex.Scheduler

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
interface SchedulerProvider{
    fun ui(): Scheduler
    fun computation(): Scheduler
    fun io(): Scheduler
    fun mainThread() : Scheduler
}