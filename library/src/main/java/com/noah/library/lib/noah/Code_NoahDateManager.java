package com.noah.library.lib.noah;

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


    private final static SimpleDateFormat stSdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");

    private final static int JUST_BEFORE = 1;
    private final static int HOUR_AGO = 60;
    private final static int DAY_AGO = 1440;
    private final static int WEEK_AGO = 10080;
    private final static int MONTH_AGO = 43800;
    private final static int YEAR_AGO = 525600;


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

    /**
     * 지정날의 0시 0분 0초의 밀리세컨드를 리턴
     *
     * @param date    기준날짜
     * @return long
     * @throws Exception
     */
    public static long seltDateMinTime(String date) throws Exception {

        return yyyyMMdd.parse(date).getTime();

    }

    /**
     * 지정날의 23시 59분 59초의 밀리세컨드를 리턴
     *
     * @param date    기준날짜
     * @return long
     * @throws Exception
     */
    public static long seltDateMaxTime(String date) throws Exception {
        Calendar cal = Calendar.getInstance();

        cal.setTime(yyyyMMdd.parse(date));
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);

        return cal.getTime().getTime();

    }





    public static String subtractTime(String standardDate,String subtractDate){
        String result = "";
        try {
            long sec = getSecond(standardDate,subtractDate);
            result = selectorTimeZone(sec);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        return result;
    }

    public static String subtractTime(String standardDate,Date subtractDate){
        String result = "";
        try {
            long sec = getSecond(standardDate,subtractDate);
            result = selectorTimeZone(sec);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        return result;
    }

    public static String subtractTime(Date standardDate,String subtractDate){
        String result = "";
        try {
            long sec = getSecond(standardDate,subtractDate);
            result = selectorTimeZone(sec);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        return result;
    }

    public static String subtractTime(Date standardDate,long subtractDate){
        String result = "";
        try {
            long sec = getSecond(standardDate,subtractDate);
            result = selectorTimeZone(sec);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        return result;
    }

    public static String subtractTime(Date standardDate,Date subtractDate){
        String result = "";
        try {
            long sec = getSecond(standardDate,subtractDate);
            result = selectorTimeZone(sec);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        return result;
    }


    public static long getSecond(String standardDate,String subtractDate) throws ParseException{
        long standardDateTime = stSdf.parse(standardDate).getTime();
        long subtractDateTime = stSdf.parse(subtractDate).getTime();

        long diff = standardDateTime - subtractDateTime;

        long sec = diff / 1000/60;

        return sec;
    }


    public static long getSecond(String standardDate,Date subtractDate) throws ParseException{
        long standardDateTime = stSdf.parse(standardDate).getTime();
        long subtractDateTime = subtractDate.getTime();

        return secondCalculation(standardDateTime, subtractDateTime);
    }

    public static long getSecond(Date standardDate,String subtractDate) throws ParseException{
        long standardDateTime = standardDate.getTime();
        long subtractDateTime = stSdf.parse(subtractDate).getTime();

        long diff = standardDateTime - subtractDateTime;

        long sec = diff / 1000/60;

        return sec;
    }

    public static long getSecond(Date standardDate,long subtractDate) throws ParseException{
        long standardDateTime = standardDate.getTime();
        long subtractDateTime = subtractDate;

        long diff = standardDateTime - subtractDateTime;

        long sec = diff / 1000/60;

        return sec;
    }


    public static long getSecond(Date standardDate,Date subtractDate) throws ParseException{
        long standardDateTime = standardDate.getTime();
        long subtractDateTime = subtractDate.getTime();

        return secondCalculation(standardDateTime, subtractDateTime);
    }

    public static long secondCalculation(long standardDateTime , long subtractDateTime){
        long diff = standardDateTime - subtractDateTime;
        long sec = diff / 1000/60;
        return sec;
    }

    public static String selectorTimeZone(long sec) throws Exception{
        String result = "";
        System.out.println(sec+":::sec::");
        if(sec >= 0 && sec < JUST_BEFORE)
            result = "방금";
        else if(sec >= JUST_BEFORE && sec < HOUR_AGO) // 1분 ~59분
            result = sec+"분" ;
        else if(sec >= HOUR_AGO && sec < DAY_AGO)// 1시간 ~ 23시간
            result = sec/HOUR_AGO+"시간" ;
        else if(sec >= DAY_AGO && sec < WEEK_AGO)//1일 ~ 6일
            result = sec/DAY_AGO+"일" ;
        else if(sec >= WEEK_AGO && sec < MONTH_AGO)//1주 ~ 4주
            result = sec/WEEK_AGO+"주";
        else if(sec >= MONTH_AGO && sec < YEAR_AGO)
            result = sec/MONTH_AGO + "달";
        else if(sec >= YEAR_AGO)
            result = sec/YEAR_AGO+"년";
        else
            result = "-";

        return result;
    }



    public static String selectorTimeZone2(Date date1, Date date2){
        String result = "";

        long calDate = date1.getTime() - date2.getTime();
        long calDateDays = calDate / (60 * 1000);

        calDateDays = Math.abs(calDateDays);

        System.out.println("두 날짜의 날짜 차이: " + calDateDays);

        if(calDateDays >= 0 && calDateDays < JUST_BEFORE)
            result = "방금 전";
        else if(calDateDays >= JUST_BEFORE && calDateDays < HOUR_AGO) // 1분 ~59분
            result = calDateDays+"분 전" ;
        else if(calDateDays >= HOUR_AGO && calDateDays < DAY_AGO)// 1시간 ~ 23시간
            result = calDateDays/HOUR_AGO+"시간 전" ;
        else
            result = stSdf.format(date1);


        return result;
    }

    public static boolean getAbleStatus(Date date1, Date date2, int interval){
        long calDate = date2.getTime() - date1.getTime();

        Log.d("###","calDate : " + calDate);
        Log.d("###","getIntervalTime(interval) * 2 : " + getIntervalTime(interval) * 2);


        if ((calDate) > getIntervalTime(interval) * 2){
            return false;
        }

        return true;
    }

    public static long getIntervalTime(int i){
        long time = 0;

        Log.d("###","인터벌 : " + i);


        switch (i) {
            case 0:
                time = (long)(1 * 60 * 1000);
                break;
            case 1:
                time = (long)(5 * 60 * 1000);
                break;
            case 2:
                time = (long)(10 * 60 * 1000);
                break;
            case 3:
                time = (long)(30 * 60 * 1000);
                break;
            case 4:
                time = (long)(60 * 60 * 1000);
                break;
            case 5:
                time = (long)(120 * 60 * 1000);
                break;
        }

        return time;
    }
}
