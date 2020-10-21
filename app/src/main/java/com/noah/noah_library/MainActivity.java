package com.noah.noah_library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.noah.library.lib.luka.Code_LukaSharingPreferences;
import com.noah.library.lib.noah.Code_NoahBasicApiVO;
import com.noah.library.lib.noah.Code_NoahDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Code_LukaSharingPreferences.init(getPackageName());
        Code_LukaSharingPreferences pref = new Code_LukaSharingPreferences(this);

        pref.putKey("abc",123);

        int abc = pref.getValue("abc",0);



    }


}