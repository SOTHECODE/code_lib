package com.noah.library.date;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 날짜 차이를 계산해주는 Manager
 */
public class DateDifferenceManager {

    /**
     * String 타입을 날짜의 차이를 계싼한다.
     * date1 - date2
     * @param date1
     * @param date2
     * @return
     */
    public static long timeDifference(String date1, String date2) {
        Log.d("###", "getBirthDayDate: " + date1);
        if (date1.equals("0")) {
            return 0;
        }
        String sToday;
        Calendar today = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (date2.equals("")) {
            sToday = sdf.format(today.getTime());
        } else {
            int mYear = Integer.parseInt(date2.substring(0, date2.indexOf("-")));
            int mMonth = Integer.parseInt(date2.substring(date2.indexOf("-") + 1, date2.lastIndexOf("-")));
            int mDay = Integer.parseInt(date2.substring(date2.lastIndexOf("-") + 1, date2.lastIndexOf(" ")));
            today.set(mYear, mMonth, mDay);
            sToday = sdf.format(today.getTime());
        }

        Date firstDate = null;
        Date secondDate = null;
        try {
            firstDate = sdf.parse(sToday);
            secondDate = sdf.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Log.d("###", firstDate.getTime() + " : " + secondDate.getTime());
        long calDate = firstDate.getTime() - secondDate.getTime();

        long calDateDays = calDate / ( 60 * 1000);

        calDateDays = Math.abs(calDateDays);

        return calDateDays;
    }


    /**
     * Date의 차이를 계산한다.
     * @param date1
     * @param date2
     * @return
     */
    public static long timeDifference(Date date1, Date date2){

        long calDate = date1.getTime() - date2.getTime();

        long calDateDays = calDate / ( 60 * 1000);

        calDateDays = Math.abs(calDateDays);

        return calDateDays;
    }

}
