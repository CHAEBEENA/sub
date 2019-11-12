package kr.co.gadaga.official.internal

object DefaultScheduler: Scheduler {

    private var delegate: Scheduler = AsyncScheduler

    /**
     * set new delegate scheduler, null to revert to the default async one
     */
    fun setDelegate(newDelegate: Scheduler?) {
        delegate = newDelegate ?: AsyncScheduler
    }

    override fun execute(task: () -> Unit) {
        delegate.execute(task)
    }

    override fun postToMainThread(task: () -> Unit) {
        delegate.postToMainThread(task)
    }

    override fun postDelayedToMainThread(task: () -> Unit, delayMillis: Long) {
        delegate.postDelayedToMainThread(task, delayMillis)
    }
}