package com.noah.library.lib;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 날짜 차이를 계산해주는 Manager
 */
public class Code_NoahDateManager {

    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private final static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");

    private final static SimpleDateFormat kryyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);

    private final static SimpleDateFormat kryyyyMMdd = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);


    /**
     * 현재시간 String 반환
     * @return
     */
    public static String getNowStringDate() {
        return sdf.format(new Date());
    }

    /**
     * String을 한국 시간 Date 반환
     * @param s
     * @return
     * @throws Exception
     */
    public static Date stringToYyyyMMddHHmmss(String s) throws Exception {
        return kryyyyMMddHHmmss.parse(s);

    }
    /**
     * 현재 한국 시간 Date 반환
     * @return
     * @throws ParseException
     */
    public static Date krDate() throws ParseException {

        return kryyyyMMddHHmmss.parse(kryyyyMMddHHmmss.format(new Date()));
    }

    /**
     * 날짜 더하기
     * @param date 기준 날짜
     * @param field 영역
     * @param val 더할 값
     * @return 더한 시간
     */
    public static Date addDate(Date date, int field, int val) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(field, val);

        return cal.getTime();
    }

    /**
     * 날짜 차이 구하기 ( 일 차이 )
     * String - String
     * @param date1 기준 날짜
     * @param date2 뺄 날짜
     * @return 날짜 차이
     * @throws Exception
     */
    public static int dateDifference(String date1, String date2) throws Exception {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        // date1, date2 두 날짜를 parse()를 통해 Date형으로 변환.
        Date FirstDate = format.parse(date1);
        Date SecondDate = format.parse(date2);

        // Date로 변환된 두 날짜를 계산한 뒤 그 리턴값으로 long type 변수를 초기화 하고 있다.
        // 연산결과 -950400000. long type 으로 return 된다.
        long calDate = FirstDate.getTime() - SecondDate.getTime();

        // Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다.
        // 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
        long calDateDays = calDate / (24 * 60 * 60 * 1000);

        calDateDays = Math.abs(calDateDays);

        return (int) calDateDays;

    }
    /**
     * 날짜 차이 구하기 ( 일 차이 )
     * Date - Date
     * @param date1 기준 날짜
     * @param date2 뺄 날짜
     * @return 날짜 차이
     * @throws Exception
     */
    public static int dateDifference(Date date1, Date date2) throws Exception {

        // Date로 변환된 두 날짜를 계산한 뒤 그 리턴값으로 long type 변수를 초기화 하고 있다.
        // 연산결과 -950400000. long type 으로 return 된다.
        long calDate = date1.getTime() - date2.getTime();

        // Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다.
        // 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
        long calDateDays = calDate / (24 * 60 * 60 * 1000);

        calDateDays = Math.abs(calDateDays);

        System.out.println("두 날짜의 날짜 차이: " + calDateDays);
        return (int) calDateDays;

    }



    /**
     * limitDay를 정해 해당 날짜에서 다가올 가장빠른 upComingDay를 찾는다
     *
     * @param limitDay    기준날짜
     * @param upComingDay 다가올 날짜
     * @return Date
     * @throws Exception
     */
    public static Date upComingDay(Integer limitDay, Integer upComingDay) throws Exception {

        String[] dateArray = yyyyMMdd.format(new Date()).split("-");
        Integer day = Integer.parseInt(dateArray[2]);
        Date date;
        if (day > limitDay) {
            date = yyyyMMdd.parse(dateArray[0] + "-" + (dateArray[1] + 1) + "-" + upComingDay);
        } else {
            date = yyyyMMdd.parse(dateArray[0] + "-" + (dateArray[1]) + "-" + upComingDay);
        }

        return date;

    }
    /**
     * String 타입을 시간의 차이를 계산한다.
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
     * Date의 시간 차이를 계산한다.
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
