package com.blueskytech.rxjavademo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "xxxxxxxxx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable
                .create(new Observable<Object>() {
                    @Override
                    public void subscribe(Observer<Object> observer) {
                        observer.onNext("哈哈哈");
                        observer.onComplete();
                    }
                })
                .flatMap()
                .map(new Function<Object, Integer>() {

                    @Override
                    public Integer apply(Object o) {
                        Log.e(TAG, "apply: " + o);
                        return 111;
                    }
                })
                .subscribe(new Observer<Integer>() {


                    @Override
                    public void onNext(Integer o) {
                        Log.e(TAG, "onNext: " + o);
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: ");
                    }
                });
    }
}