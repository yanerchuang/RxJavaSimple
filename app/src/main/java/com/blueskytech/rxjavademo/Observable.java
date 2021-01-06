package com.blueskytech.rxjavademo;

import android.util.Log;

/**
 * @author : YOULU  ywj
 * date   : 2021/1/6 21:16
 */
public abstract class Observable<T> {
    private static final String TAG = "xxxxxxxxx1 ";
    public static <T> Observable<T> create(Observable<T> observable) {
        return observable;
    }

    public abstract void subscribe(Observer<T> observer);

    public Observable<T> flatMap() {
        return new Observable<T>() {
            @Override
            public void subscribe(Observer<T> observer) {
                Observer<T> observerFlat = new Observer<T>() {
                    @Override
                    public void onNext(T t) {
                        Log.e(TAG, "onNext1: "+t );
                        observer.onNext(t);
                    }

                    @Override
                    public void onComplete() {
                        observer.onComplete();
                    }
                };
                Observable.this.subscribe(observerFlat);
            }
        };
    }

    public <R> Observable<R> map(Function<T, R> function) {

        return new Observable<R>() {
            @Override
            public void subscribe(Observer<R> observer) {
                Observer<T> observer2 = new Observer<T>() {
                    @Override
                    public void onNext(T t) {
                        R r = function.apply(t);
                        observer.onNext(r);
                    }

                    @Override
                    public void onComplete() {
                        observer.onComplete();
                    }
                };
                Observable.this.subscribe(observer2);
            }
        };
    }

} 