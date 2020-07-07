package com.noah.library.event;

import android.os.SystemClock;
import android.view.View;

public abstract class Code_OnSingleClickListener implements View.OnClickListener {
    // 중복 클릭 방지 시간 설정
    private static final long MIN_CLICK_INTERVAL=600;

    private long mLastClickTime;

    public abstract void onSingleClick(View v);

    @Override
    public final void onClick(View v) {
        long currentClickTime= SystemClock.uptimeMillis();
        long elapsedTime=currentClickTime-mLastClickTime;

        if(elapsedTime<=MIN_CLICK_INTERVAL)
            return;
        else {
            // 중복 클릭아 아니라면 추상함수 호출
            mLastClickTime = currentClickTime;
            onSingleClick(v);
        }


    }

}