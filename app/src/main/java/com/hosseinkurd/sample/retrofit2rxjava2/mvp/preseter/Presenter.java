package com.hosseinkurd.sample.retrofit2rxjava2.mvp.preseter;

public interface Presenter<V> {

    void attachListener(V listener);

    void detachListener();

}