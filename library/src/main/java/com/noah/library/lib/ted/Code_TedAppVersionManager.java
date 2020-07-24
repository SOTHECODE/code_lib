package com.noah.library.lib.ted;

import java.util.ArrayList;

public class Code_TedAppVersionManager {
    public static ArrayList<Integer> getVersionInteger(String appNecessaryVersion) {
        String[] stringNNums = appNecessaryVersion.split("\\.");
        ArrayList<Integer> nNums = new ArrayList<>();
        for (String num : stringNNums) {
            nNums.add(Integer.parseInt(num));
        }
        return nNums;
    }

    public static boolean isUpdate(ArrayList<Integer> nNums, ArrayList<Integer> nowNums) {

        for(int i=0; i<nNums.size(); i++){
            int version = nNums.get(i);
            for (int k=0; k<nowNums.size(); k++){
                int nowVersion = nowNums.get(k);
                if(i==k) {
                    if (nowVersion < version)
                        return true;
                }
            }
        }
        return false;
    }
}
