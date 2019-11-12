package kr.co.gadaga.official.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kr.co.gadaga.official.internal.DefaultScheduler
import kr.co.gadaga.official.internal.Scheduler
import kr.co.gadaga.official.util.Result

/**
 * google / iosched
 * https://github.com/google/iosched
 */
abstract class UseCase<in P, R> {

    protected var taskScheduler: Scheduler = DefaultScheduler

    operator fun invoke(parameters: P, result: MutableLiveData<Result<R>>) {

        try {
            taskScheduler.execute {
                try {
                    execute(parameters).let {
                        result.postValue(Result.Success(it))
                    }
                } catch (exception: Exception) {
                    result.postValue(Result.Error(exception))
                }
            }

        } catch (exception: Exception) {
            result.postValue(Result.Error(exception))
        }
    }

    operator fun invoke(parameters: P): LiveData<Result<R>> {
        val liveCallback: MutableLiveData<Result<R>> = MutableLiveData()
        this(parameters, liveCallback)
        return liveCallback
    }

    /**
     *  Override this to set the code to be executed
     */
    protected abstract fun execute(parameters: P): R
}

/**
 * markScheduleUiHintsShownUseCase()
 */
operator fun <R> UseCase<Unit, R>.invoke(): LiveData<Result<R>> = this(Unit)

/**
 * getTimeZoneUseCase(preferConferenceTimeZoneResult)
 */
operator fun <R> UseCase<Unit, R>.invoke(result: MutableLiveData<Result<R>>) = this(Unit, result)