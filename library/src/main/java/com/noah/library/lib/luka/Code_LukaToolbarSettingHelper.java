package com.noah.library.lib.luka;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class Code_LukaToolbarSettingHelper {

    // Activity
    private AppCompatActivity mCompatActivity;

    // Navigation callback용
    public interface ToolbarCallback {
        void call();
    }


    public Code_LukaToolbarSettingHelper(AppCompatActivity activity) {
        this.mCompatActivity = activity;
    }

    /**
     * 기본 툴바
     * @param toolbar
     */
    public void basicToolbar(Toolbar toolbar) {
        mCompatActivity.setSupportActionBar(toolbar);
        if (mCompatActivity.getSupportActionBar() != null) {
            mCompatActivity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    /**
     * 왼쪽 상단에 아이콘이 있는 툴바
     * @param toolbar
     * @param icon
     * @param callback
     */
    public void navigationIconToolbar(Toolbar toolbar, int icon, final ToolbarCallback callback) {
        mCompatActivity.setSupportActionBar(toolbar);
        if (mCompatActivity.getSupportActionBar() != null) {
            mCompatActivity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        toolbar.setNavigationIcon(icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               callback.call();
            }
        });
    }



}