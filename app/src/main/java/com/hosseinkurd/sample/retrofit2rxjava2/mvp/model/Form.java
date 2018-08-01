package com.hosseinkurd.sample.retrofit2rxjava2.mvp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Form implements Parcelable {

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("X-Developer")
    @Expose
    private String xDeveloper;

    public Form() {
    }


    public String getXDeveloper() {
        return xDeveloper;
    }

    public void setXDeveloper(String xDeveloper) {
        this.xDeveloper = xDeveloper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.xDeveloper);
    }

    protected Form(Parcel in) {
        this.name = in.readString();
        this.xDeveloper = in.readString();
    }

    public static final Creator<Form> CREATOR = new Creator<Form>() {
        @Override
        public Form createFromParcel(Parcel source) {
            return new Form(source);
        }

        @Override
        public Form[] newArray(int size) {
            return new Form[size];
        }
    };
}
