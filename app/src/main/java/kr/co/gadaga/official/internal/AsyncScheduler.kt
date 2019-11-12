package kr.co.gadaga.official.internal

import android.os.Handler
import android.os.Looper
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

private const val N_THREADS = 4

internal object AsyncScheduler: Scheduler {

    private val executorService: ExecutorService = Executors.newFixedThreadPool(N_THREADS)

    override fun execute(task: () -> Unit) {
        executorService.execute(task)
    }

    override fun postToMainThread(task: () -> Unit) {
        if(isMainThread()) task()
        else {
            val mainHandler = Handler(Looper.getMainLooper())
            mainHandler.post(task)
        }
    }

    override fun postDelayedToMainThread(task: () -> Unit, delayMillis: Long) {
        val mainHandler = Handler(Looper.getMainLooper())
        mainHandler.postDelayed(task, delayMillis)
    }

    private fun isMainThread(): Boolean {
        return Looper.getMainLooper().thread === Thread.currentThread()
    }
}