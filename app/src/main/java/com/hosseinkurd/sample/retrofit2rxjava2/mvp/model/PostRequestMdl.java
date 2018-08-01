
package com.hosseinkurd.sample.retrofit2rxjava2.mvp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostRequestMdl implements Parcelable {// Created From : http://www.jsonschema2pojo.org/

    @SerializedName("form")
    @Expose
    private Form form;
    @SerializedName("headers")
    @Expose
    private Headers headers;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("url")
    @Expose
    private String url;

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.form, flags);
        dest.writeParcelable(this.headers, flags);
        dest.writeString(this.origin);
        dest.writeString(this.url);
    }

    public PostRequestMdl() {
    }

    protected PostRequestMdl(Parcel in) {
        this.form = in.readParcelable(Form.class.getClassLoader());
        this.headers = in.readParcelable(Headers.class.getClassLoader());
        this.origin = in.readString();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<PostRequestMdl> CREATOR = new Parcelable.Creator<PostRequestMdl>() {
        @Override
        public PostRequestMdl createFromParcel(Parcel source) {
            return new PostRequestMdl(source);
        }

        @Override
        public PostRequestMdl[] newArray(int size) {
            return new PostRequestMdl[size];
        }
    };
}
