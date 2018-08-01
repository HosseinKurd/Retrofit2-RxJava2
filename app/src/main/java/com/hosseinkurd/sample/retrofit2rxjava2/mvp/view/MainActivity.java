package com.hosseinkurd.sample.retrofit2rxjava2.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.hosseinkurd.sample.retrofit2rxjava2.R;
import com.hosseinkurd.sample.retrofit2rxjava2.mvp.model.PostRequestMdl;
import com.hosseinkurd.sample.retrofit2rxjava2.mvp.preseter.PostRequest;
import com.hosseinkurd.sample.retrofit2rxjava2.mvp.preseter.PostRequestListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements PostRequestListener {

    private EditText edtMobile;
    private TextView txtStatus;
    private PostRequest postRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setResources();
    }

    @Override
    protected void onStart() {
        super.onStart();
        postRequest = new PostRequest();
        postRequest.attachListener(this);
    }

    @Override
    protected void onDestroy() {
        postRequest.detachListener();

        super.onDestroy();
    }

    private void setResources() {
        edtMobile = findViewById(R.id.edt_mobile_activity_main);
        txtStatus = findViewById(R.id.txt_status_activity_main);
        findViewById(R.id.btn_request_activity_main).setOnClickListener(v -> request());
    }

    private void request() { // Check Logcat for tag : OkHttp
        Map<String, String> params = new HashMap<>();
        params.put("X-Developer", "Kurdia");
        params.put("Name", edtMobile.getText().toString());

        postRequest.postRequest(params);

        txtStatus.setText(String.valueOf("Request Send !"));
    }

    @Override
    public void onResponse(PostRequestMdl postRequestMdl) {
        txtStatus.setText(String.format("Name : %s\nX-Developer : %s", postRequestMdl.getForm().getName(), postRequestMdl.getHeaders().getXDeveloper()));
    }

    @Override
    public void onError(Throwable e) {
        txtStatus.setText(String.valueOf("onError : " + e.getMessage()));
    }

}