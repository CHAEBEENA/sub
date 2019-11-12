package kr.co.gadaga.official.internal

interface Scheduler {

    fun execute(task: () -> Unit)

    fun postToMainThread(task: () -> Unit)

    fun postDelayedToMainThread(task: () -> Unit, delayMillis: Long)
}