package com.noah.library.event;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by ryang on 2017-11-15.
 */

public class Code_BackPressCloseHandler {

    private long backKeyPressedTime = 0;
    private Activity activity;

    public Code_BackPressCloseHandler(Activity context){
        this.activity = context;
    }

    public void onBackPressed(){
        if(System.currentTimeMillis() > backKeyPressedTime + 2000){
            backKeyPressedTime = System.currentTimeMillis();
            showGuide();
            return;
        }
        if(System.currentTimeMillis() <= backKeyPressedTime + 2000){
            activity.finish();
        }
    }

    private void showGuide(){
        Toast toast = Toast.makeText(activity, "'뒤로'버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
        toast.show();
    }
}
