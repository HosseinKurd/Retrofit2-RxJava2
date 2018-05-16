package com.hosseinkurd.sample.retrofit2rxjava2.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hosseinkurd.sample.retrofit2rxjava2.R;
import com.hosseinkurd.sample.retrofit2rxjava2.mvp.preseter.MobileRegisterListener;
import com.hosseinkurd.sample.retrofit2rxjava2.mvp.preseter.MobileRegisterPresenter;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements MobileRegisterListener {

    private EditText                edtMobile;
    private TextView                txtStatus;
    private MobileRegisterPresenter mobileRegisterPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setResources();
    }

    @Override
    protected void onStart() {
        super.onStart();

        mobileRegisterPresenter = new MobileRegisterPresenter();
        mobileRegisterPresenter.attachListener(this);
    }

    @Override
    protected void onDestroy() {
        mobileRegisterPresenter.detachListener();

        super.onDestroy();
    }

    private void setResources() {
        edtMobile = findViewById(R.id.edt_mobile_activity_main);
        txtStatus = findViewById(R.id.txt_status_activity_main);
        findViewById(R.id.btn_request_activity_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request();
            }
        });
    }

    private void request() { // Check Logcat for tag : OkHttp
        Map<String, String> params = new HashMap<>();
        params.put("app", "pishbini");
        params.put("mobile", edtMobile.getText().toString());

        mobileRegisterPresenter.register(params);

        txtStatus.setText(String.valueOf("Request Send !"));
    }

    @Override
    public void onFailed(String msg) {
        txtStatus.setText(String.valueOf("onFailed : " + msg));
    }

    @Override
    public void onCodeSent(String msg) {
        txtStatus.setText(String.valueOf("onCodeSent : " + msg));
    }

    @Override
    public void onError(Throwable e) {
        txtStatus.setText(String.valueOf("onError : " + e.getMessage()));
    }

}