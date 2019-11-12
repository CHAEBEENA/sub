package kr.co.gadaga.official.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.MainThreadDisposable

fun <T> LiveData<T>.toFlowable(): Flowable<T> =
    Flowable.create({ emitter ->
        val observer = Observer<T> { it?.let(emitter::onNext) }
        observeForever(observer)

        /**
         * Sets a Cancellable on this emitter; any previous {@link Disposable} or {@link Cancellable} will be disposed/cancelled.
         */
        emitter.setCancellable {
            object : MainThreadDisposable() { override fun onDispose() = removeObserver(observer) }
        }
        /**
         * Keeps only the latest onNext value, overwriting any previous value if the
         * downstream can't keep up.
         */
    }, BackpressureStrategy.LATEST)

fun <X, Y> LiveData<X>.map(body: (X) -> Y): LiveData<Y> {
    return Transformations.map(this, body)
}

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, observer: Observer<T>) = liveData.observe(this, observer)

fun <T> MutableCollection<T>.compatRemoveIf(predicate: (T) -> Boolean): Boolean {
    val it = iterator()
    var removed = false
    while (it.hasNext()) {
        if (predicate(it.next())) {
            it.remove()
            removed = true
        }
    }
    return removed
}

