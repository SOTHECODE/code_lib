package com.noah.library.lib.noah;

import android.util.Log;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Code_NoahCustomCallback<T> implements Callback<Code_NoahBasicApiVO<T>> {

    Code_NoahRetrofitCallback<T> callback;

    public final static String ERR_1 = "err1";
    public final static String ERR_2 = "err2";
    public final static String ERR_3 = "err3";
    public final static String ERR_4 = "err4";

    @Override
    public void onResponse(Call<Code_NoahBasicApiVO<T>> call, Response<Code_NoahBasicApiVO<T>> response) {
        if (response.isSuccessful()) {
            if (response.body() != null) {
                if (response.body().getResult().contains("ok"))
                    callback.ok(response.body().getData());
                else
                    callback.fail(ERR_1);
            } else {
                callback.fail(ERR_2);
            }
        } else {
            int statusCode = response.code();
            ResponseBody errorBody = response.errorBody();
            callback.fail(ERR_3);
            Log.d("###", "fail " + statusCode + errorBody.toString());
        }
    }

    @Override
    public void onFailure(Call<Code_NoahBasicApiVO<T>> call, Throwable t) {
        callback.fail(ERR_4);
        Log.d("###", "fail " + t.getMessage());
    }



    public void setCallback(Code_NoahRetrofitCallback<T> callback) {
        this.callback = callback;
    }

    ;


}
