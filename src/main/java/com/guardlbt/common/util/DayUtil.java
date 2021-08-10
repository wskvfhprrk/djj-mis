package com.guardlbt.common.util;

import java.util.Calendar;
import java.util.Date;

public class DayUtil {

    public static Date getYesterday() {
        Calendar baginCalender = Calendar.getInstance();
        baginCalender.add(Calendar.DATE, -1);
        baginCalender.set(Calendar.HOUR_OF_DAY, 0);
        baginCalender.set(Calendar.MINUTE, 0);
        baginCalender.set(Calendar.SECOND, 0);
        baginCalender.set(Calendar.MILLISECOND, 0);
        Date date = baginCalender.getTime();
        return date;
    }

    public static Long getYesterdayTime() {
        return DayUtil.getYesterday().getTime();
    }

    public static Date getBegin() {
        return DayUtil.getYesterday();
    }

    public static Date getEnd() {
        Calendar baginCalender = Calendar.getInstance();
        baginCalender.set(Calendar.HOUR_OF_DAY, 0);
        baginCalender.set(Calendar.MINUTE, 0);
        baginCalender.set(Calendar.SECOND, 0);
        baginCalender.set(Calendar.MILLISECOND, 0);
        Date date = baginCalender.getTime();
        return date;
    }

//    public static void main(String[] args) {
//        Date begin = getBegin();
//        Date end = getEnd();
//        System.out.println(begin);
//        System.out.println(end);
//    }
}
