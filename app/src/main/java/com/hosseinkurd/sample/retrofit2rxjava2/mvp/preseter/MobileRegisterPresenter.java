package com.hosseinkurd.sample.retrofit2rxjava2.mvp.preseter;

import com.hosseinkurd.sample.retrofit2rxjava2.mvp.model.MobileRegisterMdl;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MobileRegisterPresenter implements Presenter<MobileRegisterListener> {

    private MobileRegisterListener listener;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void attachListener(MobileRegisterListener listener) {
        this.listener = listener;
    }

    @Override
    public void detachListener() {
        listener = null;
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void register(Map<String, String> fields) {

        compositeDisposable.add(APIClient.getDefaultClient().create(APIClient.APIInterface.class).mobileRegister(fields)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<MobileRegisterMdl>() {
                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError(e);
                    }

                    @Override
                    public void onNext(MobileRegisterMdl response) {
                        if (response.getCode().equals("200")) {
                            listener.onCodeSent(response.getMessage());
                        } else {
                            listener.onFailed(response.getMessage());
                        }
                    }
                }));
    }

}