package kr.co.gadaga.official.ext

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

operator fun CompositeDisposable.plus(disposable: Disposable) = apply { add(disposable) }