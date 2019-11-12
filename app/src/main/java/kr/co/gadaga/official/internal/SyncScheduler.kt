package kr.co.gadaga.official.internal

object SyncScheduler: Scheduler {

    private val postDelayedTasks = mutableListOf<() -> Unit>()

    override fun execute(task: () -> Unit) = task()

    override fun postToMainThread(task: () -> Unit) = task()

    override fun postDelayedToMainThread(task: () -> Unit, delayMillis: Long) {
        postDelayedTasks.add(task)
    }

    fun runAllScheduledPostDelayedTasks() {
        val tasks = postDelayedTasks.toList()
        clearScheduledPostDelayedTasks()

        for(task in tasks) {
            task()
        }
    }

    fun clearScheduledPostDelayedTasks() = postDelayedTasks.clear()
}