package com.hosseinkurd.sample.retrofit2rxjava2.mvp.preseter;

import com.hosseinkurd.sample.retrofit2rxjava2.mvp.model.MobileRegisterMdl;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class APIClient {

    static Retrofit getDefaultClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                // .cache(new Cache(context.getCacheDir(), 10 * 1024 * 1024))
                .addInterceptor(interceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl("http://ws.v3.abring.ir/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }

    public interface APIInterface {

        @FormUrlEncoded
        @POST("index.php?r=player/mobile-register")
        Observable<MobileRegisterMdl> mobileRegister(@FieldMap Map<String, String> fields);

    }

}