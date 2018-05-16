package com.hosseinkurd.sample.retrofit2rxjava2.mvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MobileRegisterMdl { // Made From : http://www.jsonschema2pojo.org/

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    public String getCode() {
        return code;
    }

    public MobileRegisterMdl setCode(String code) {
        this.code = code;
        return this;
    }

    public String getResult() {
        return result;
    }

    public MobileRegisterMdl setResult(String result) {
        this.result = result;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MobileRegisterMdl setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public MobileRegisterMdl setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

}