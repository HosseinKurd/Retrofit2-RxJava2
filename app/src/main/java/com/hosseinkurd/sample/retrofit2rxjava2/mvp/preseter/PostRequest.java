package com.hosseinkurd.sample.retrofit2rxjava2.mvp.preseter;

import com.hosseinkurd.sample.retrofit2rxjava2.mvp.model.PostRequestMdl;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class PostRequest implements Presenter<PostRequestListener> {

    private PostRequestListener listener;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void attachListener(PostRequestListener listener) {
        this.listener = listener;
    }

    @Override
    public void detachListener() {
        listener = null;
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void postRequest(Map<String, String> fields) {
        compositeDisposable.add(APIClient.getDefaultClient().create(APIClient.APIInterface.class).postRequest(fields)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<PostRequestMdl>() {
                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError(e);
                    }

                    @Override
                    public void onNext(PostRequestMdl response) {
                        listener.onResponse(response);
                    }
                }));
    }

}