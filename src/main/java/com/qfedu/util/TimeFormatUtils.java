package com.qfedu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormatUtils {

    public static String getFormateTimes(Date time){

        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
        String date = sf.format(time);

        return date;
    }

    public static String getFormateTime(String time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
             date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
        return sf.format(date);
    }
    public static void main(String[] args) {
       Date date = new Date("2019-02-08");

        System.out.println(TimeFormatUtils.getFormateTimes(date));
        System.out.println(TimeFormatUtils.getFormateTime("2019-02-08"));

    }
}
