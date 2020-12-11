package com.example.springboottest1;


import com.example.springboottest1.utils.PinyinUtils;

import java.text.Collator;
import java.util.*;

public class ListSort {
    public static void main(String[] args) {

        //1.对于数组的排序方法如下：
        String[] names = {"王林",  "杨宝", "李镇", "刘迪", "刘波"};
        Arrays.sort(names, com.ibm.icu.text.Collator.getInstance(com.ibm.icu.util.ULocale.SIMPLIFIED_CHINESE));//升序;
        System.out.println("1."+Arrays.toString(names));

        //2.对于汉字的排序：可以尝试使用ICU4J会得到更好的结果，特别是姓为某些生僻字的时候，
        //用com.ibm.icu.text.Collator替换java.text.Collator，用com.ibm.icu.util.ULocale替换java.util.Locale

        /*3.对于枚举类型的enum1.compareTo（enum2）是按照枚举类型值在定义时的先后顺序比较的，越后面的越大，
        *而不是按照值的字母先后顺序比较的。
        比如：
        */
        List<String> list1 = new ArrayList<String>();
        list1.add("网易汽车");
        list1.add("新民汽车网");
        list1.add("钛媒体");
        list1.add("瘾科技");
        list1.add("昕薇网");
        list1.add("安倍");
        list1.add("中国");
        list1.add("中心");
        list1.add("ZX");
        list1.add("AX");
        list1.add("aX");
        list1.add("123");
        list1.add("223");
        System.out.println("2."+list1.toString());


        //Comparator<Object> comparator = Collator.getInstance(java.util.Locale.CHINESE);
        //com.ibm.icu.text.Collator.getInstance(com.ibm.icu.util.ULocale.SIMPLIFIED_CHINESE);
 ////////////////////注：推荐使用这种中文排序方式
        Collections.sort(list1, com.ibm.icu.text.Collator.getInstance(com.ibm.icu.util.ULocale.SIMPLIFIED_CHINESE));
        System.out.println("3."+list1.toString());



////////////////////////////////////////////////////////注：不推荐，生僻字排序错误
         Collections.sort(list1, new Comparator<String>() {
         @Override
         public int compare(String o1, String o2) {
         return Collator.getInstance(java.util.Locale.CHINA).compare(o1, o2);
         }
         });

        System.out.println("4."+list1.toString());


////////////////////////注：推荐使用这种中文排序方式
        Collections.sort(list1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return com.ibm.icu.text.Collator.getInstance(com.ibm.icu.util.ULocale.SIMPLIFIED_CHINESE).compare(o1, o2);
            }
        });

        System.out.println("4.5"+list1.toString());
        /*汉子按照中文首字母排序：
        *用普通的java.util.Locale.CHINESE排序的效果为：
        * [安倍, 网易汽车, 新民汽车网, 中国, 中心, 昕薇网, 钛媒体, 瘾科技]
        *用icu的排序效果为：
        *[安倍, 钛媒体, 网易汽车, 昕薇网, 新民汽车网, 瘾科技, 中国, 中心]
         */

        sort();
        sort1();
    }

    public static List<String> init() {
        List<String> list = new ArrayList<String>();
        list.add("李方");
        list.add("郭云2");
        list.add("郭云3");
        list.add("赵飞");
        list.add("E马路");
        list.add("e马路");
        list.add("马路");
        list.add("马l路");
        list.add("马L路");
        list.add("马e路");
        list.add("网易汽车");
        list.add("新民汽车网");
        list.add("钛媒体");
        list.add("瘾科技");
        list.add("昕薇网");
        list.add("安倍");
        list.add("中国");
        list.add("中心");
        list.add("xxx");
        list.add("xxy");
        list.add("432");
        return list;
    }

    public static void sort() {
        List<String> list = init();
        //不推荐这种排序方式（数字，字母排前面，但是生僻字排序错误）
        Comparator<String> comparator = new Comparator<String>() {

            public int compare(String o1, String o2) {
                Collator collator = Collator.getInstance();
                return collator.getCollationKey(o1).compareTo(
                        collator.getCollationKey(o2));
            }
        };
        Collections.sort(list, comparator);
        System.out.println("4"+list);
    }

    public static void sort1() {
        List<String> list = init();
        //获取list某一属性进行正序排列（数字，字母，中文混合）
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a=PinyinUtils.ToPinyinAndGetFirstChar(o1);
                String b=(PinyinUtils.ToPinyinAndGetFirstChar(o2));
                int i = a.substring(0, 1).compareTo(b.substring(0, 1));
                return i;
            }
        });
        System.out.println("5"+list);
    }

}
