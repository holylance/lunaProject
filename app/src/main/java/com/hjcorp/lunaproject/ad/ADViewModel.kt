package com.hjcorp.lunaproject.ad

import com.hjcorp.lunaproject.shared.BaseViewModel
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class ADViewModel : BaseViewModel() {

    var count = 0

    fun everySeconds(): Observable<Long> {
        count = 0
        return Observable.interval(1, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .doOnError {}
            .takeWhile { count <= 1 }
    }
}
