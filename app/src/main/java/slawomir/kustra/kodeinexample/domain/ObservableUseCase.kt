package slawomir.kustra.kodeinexample.domain

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

abstract class ObservableUseCase<T, in Params> constructor(private val postExecutionThread: PostExecutionThread) {

    private val disposable = CompositeDisposable()

    protected abstract fun getObservableUseCase(params: Params? = null): Observable<T>

    fun execute(observer: DisposableObserver<T>, params: Params) {
        disposable.add(
            getObservableUseCase(params)
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread.scheduler)
                .subscribeWith(observer)
        )
    }

    fun dispose() {
        disposable.dispose()
    }
}