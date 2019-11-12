package kr.co.gadaga.official.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class LiveDataDelegate<T: Any>(
    initial: T,
    private val liveData: MutableLiveData<T> = MutableLiveData()
): LiveDataObservable<T> {

    init {
        liveData.value = initial
    }

    override fun observe(owner: LifecycleOwner, observer: (T) -> Unit) = liveData.observe(owner, Observer{ observer(it) })

    override fun observeForever(observer: (T) -> Unit) = liveData.observeForever { observer(it) }
}