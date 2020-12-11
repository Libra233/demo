package com.example.springboottest1;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import static com.example.springboottest1.utils.DateUtil.getPrevMonthDate;
import static com.example.springboottest1.utils.DateUtil.strToDate;

public class TestMain4 {
    public static void main(String[] args) {

        // select * from sys_zdlx where zdywbh ='MJGZZXT'  order by ZDLXBH
        // 找到民警工作子系统，最大编号，然后+1. 比如最新的是JG2019-08211,+1=JG2019-08212
        String itemKey = "202008";
        String a=itemKey.substring(0,4);
        System.out.println(a);
        Date date = new Date();
        SimpleDateFormat dd= new SimpleDateFormat("yyyyMM");
        String RQString =dd.format(date);
        //获取当月年份
        String NF=RQString.substring(0,4);
        System.out.println(NF);
        //获取当月月份
        String YF=RQString.substring(4,6);
        System.out.println(YF);

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        int year3 = cal.get(Calendar.YEAR);
        int month3 = cal.get(Calendar.MONTH)+1;
        int day3 = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(year3 + " 年 " + month3 + " 月 " + day3 +  " 日");
        Date date3 = cal.getTime();
        SimpleDateFormat format3= new SimpleDateFormat("yyyy-MM-dd");
        String dateStringYYYYMMDD3 = format3.format(date3);
        System.out.println(dateStringYYYYMMDD3);

        String ss = getPrevMonthDate(new Date(),2);
        Date yy = strToDate(itemKey,"yyyyMM");
        String sss = getPrevMonthDate(yy,2);

        System.out.println("-------------------"+ss);
        System.out.println("-------------------"+yy);
        System.out.println("-------------------"+sss);

        String ab = "0.680";
        String b = "-0.77";
        String c = "3.0";
        String d = "-3.0";

        System.out.println(Double.parseDouble(ab));
        System.out.println(Double.parseDouble(b));
        System.out.println(Double.parseDouble(c));
        System.out.println(Double.parseDouble(d));
        System.out.println(Double.parseDouble(d)+Double.parseDouble(ab));
        System.out.println(Double.parseDouble(d)-Double.parseDouble(ab));
        System.out.println(Double.parseDouble(ab)-Double.parseDouble(d));


        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        Date da = Date.from(localDateTime1.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("da="+ da);
    }
}
