package com.noah.library.lib.noah;

import com.google.gson.annotations.SerializedName;

public class Code_NoahBasicApiVO<T> {
    @SerializedName("result")
    private String result;
    @SerializedName("error")
    private String error;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    T data;
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BasicApiVO{" +
                "result='" + result + '\'' +
                ", error='" + error + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
