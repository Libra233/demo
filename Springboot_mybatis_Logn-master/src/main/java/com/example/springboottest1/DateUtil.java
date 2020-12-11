package com.example.springboottest1;

import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    @Autowired
    private DateUtil dateUtil;
    public static void main(String[] args) {
        String beginDateStr = "20200118";
        String endDateStr = "20200210";
        long day = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;
        try {
            beginDate = format.parse(beginDateStr);
            endDate = format.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("!!!!!!!!!!!!!!!####################--"+beginDate);
        System.out.println("!!!!!!!!!!!!!!!####################--"+endDate);
        day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!:"+day);
        String aa = String.valueOf(new Date().getTime());
        System.out.println("####################--"+aa);
        System.out.println("SSSSSSSSSSSSSSSSSSSSSS:--"+new Date().getTime());

    }
}
