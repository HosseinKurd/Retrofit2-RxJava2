
package com.hosseinkurd.sample.retrofit2rxjava2.mvp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Headers implements Parcelable {

    @SerializedName("Accept")
    @Expose
    private String accept;
    @SerializedName("Accept-Encoding")
    @Expose
    private String acceptEncoding;
    @SerializedName("Accept-Language")
    @Expose
    private String acceptLanguage;
    @SerializedName("Connection")
    @Expose
    private String connection;
    @SerializedName("Content-Length")
    @Expose
    private String contentLength;
    @SerializedName("Content-Type")
    @Expose
    private String contentType;
    @SerializedName("Host")
    @Expose
    private String host;
    @SerializedName("Origin")
    @Expose
    private String origin;
    @SerializedName("Referer")
    @Expose
    private String referer;
    @SerializedName("User-Agent")
    @Expose
    private String userAgent;
    @SerializedName("X-Developer")
    @Expose
    private String xDeveloper;

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getContentLength() {
        return contentLength;
    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getXDeveloper() {
        return xDeveloper;
    }

    public void setXDeveloper(String xDeveloper) {
        this.xDeveloper = xDeveloper;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.accept);
        dest.writeString(this.acceptEncoding);
        dest.writeString(this.acceptLanguage);
        dest.writeString(this.connection);
        dest.writeString(this.contentLength);
        dest.writeString(this.contentType);
        dest.writeString(this.host);
        dest.writeString(this.origin);
        dest.writeString(this.referer);
        dest.writeString(this.userAgent);
        dest.writeString(this.xDeveloper);
    }

    public Headers() {
    }

    protected Headers(Parcel in) {
        this.accept = in.readString();
        this.acceptEncoding = in.readString();
        this.acceptLanguage = in.readString();
        this.connection = in.readString();
        this.contentLength = in.readString();
        this.contentType = in.readString();
        this.host = in.readString();
        this.origin = in.readString();
        this.referer = in.readString();
        this.userAgent = in.readString();
        this.xDeveloper = in.readString();
    }

    public static final Parcelable.Creator<Headers> CREATOR = new Parcelable.Creator<Headers>() {
        @Override
        public Headers createFromParcel(Parcel source) {
            return new Headers(source);
        }

        @Override
        public Headers[] newArray(int size) {
            return new Headers[size];
        }
    };
}
