package com.noah.library.cash;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by LukaK
 * Ver 0.1 신규 제작
 * Ver 0.2 removeKey 추가
 * Ver 0.3 checkKey 추가
 * Ver 0.4 resetAll 추가
 */
public class LukaSharingPreferences {

    // 고유 이름 * 패키지명 사용전 꼭 입력해야함
    private static String prefName;

    private Context mContext;


    /**
     * 초기 prefName 셋팅 최초 1회만 호출
     * @param name
     */
    public static void init(String name){
        prefName = name;
    }
    // 유지
    public void LukaSharingPreferences(Context context){
        mContext = context;
    }


    public void putKey(String key, String value) {
        //SharedPreferences : 해당 프로세스내에 File 형태로 Data를 저장함 앱 삭제 전까지는 보관
        SharedPreferences pref = mContext.getSharedPreferences(prefName, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.apply();
    }


    public void putKey(String key, int value) {
        //SharedPreferences : 해당 프로세스내에 File 형태로 Data를 저장함 앱 삭제 전까지는 보관
        SharedPreferences pref = mContext.getSharedPreferences(prefName, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void putKey(String key, boolean value) {
        //SharedPreferences : 해당 프로세스내에 File 형태로 Data를 저장함 앱 삭제 전까지는 보관
        SharedPreferences pref = mContext.getSharedPreferences(prefName, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public String getValue(String key, String dftValue) {
        SharedPreferences pref = mContext.getSharedPreferences(prefName, Activity.MODE_PRIVATE);
        try {
            return pref.getString(key, dftValue);
        } catch (Exception e) {
            return dftValue;
        }
    }


    public int getValue(String key, int dftValue) {
        SharedPreferences pref = mContext.getSharedPreferences(prefName, Activity.MODE_PRIVATE);
        try {
            return pref.getInt(key, dftValue);
        } catch (Exception e) {
            return dftValue;
        }
    }

    public boolean getValue(String key, boolean dftValue) {
        SharedPreferences pref = mContext.getSharedPreferences(prefName, Activity.MODE_PRIVATE);
        try {
            return pref.getBoolean(key, dftValue);
        } catch (Exception e) {
            return dftValue;
        }
    }

    public void removeKey(String key) {
        SharedPreferences pref = mContext.getSharedPreferences(prefName, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(key);
        editor.apply();
    }

    public boolean checkKey(String key) {
        SharedPreferences pref = mContext.getSharedPreferences(prefName, Activity.MODE_PRIVATE);
        return pref.contains(key);
    }

    public void resetAll() {
        SharedPreferences pref = mContext.getSharedPreferences(prefName, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }

}
