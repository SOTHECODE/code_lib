package com.noah.library.lib.noah;

public interface Code_NoahRetrofitCallback<T> {

    void ok(T t);
    void fail(String msg);
}
