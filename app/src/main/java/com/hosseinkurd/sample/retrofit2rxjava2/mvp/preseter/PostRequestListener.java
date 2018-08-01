package com.hosseinkurd.sample.retrofit2rxjava2.mvp.preseter;

import com.hosseinkurd.sample.retrofit2rxjava2.mvp.model.PostRequestMdl;

public interface PostRequestListener {

    void onResponse(PostRequestMdl postRequestMdl);

    void onError(Throwable e);

}