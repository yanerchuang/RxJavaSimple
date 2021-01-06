package com.blueskytech.rxjavademo;

/**
 * @author : YOULU  ywj
 * date   : 2021/1/6 21:17
 */
public interface Observer<T> {
    public void onNext(T t);
    public void onComplete();
}