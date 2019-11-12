package kr.co.gadaga.official.ui.main

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class MainViewModel : ViewModel() {

    private val disposable = CompositeDisposable()



    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }
}
