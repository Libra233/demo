package com.example.springboottest1;


import com.example.springboottest1.entity.Students;
import com.example.springboottest1.utils.PinyinUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSort2 {
    public static void main(String[] args) {

        //字母，数字，中文混合排序--正序
        List<Students> students = init();
        Collections.sort(students, new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                Students newo1 = new Students();
                newo1.setName(PinyinUtils.ToPinyinAndGetFirstChar(o1.getName()));
                Students newo2 = new Students();
                newo2.setName(PinyinUtils.ToPinyinAndGetFirstChar(o2.getName()));
                int i = newo1.getName().substring(0, 1).compareTo(newo2.getName().substring(0, 1));
                return i;
            }
        });
        for(Students stu : students){
            System.out.println("score:" + stu.getScore() + ":age" + stu.getAge()+":name:"+stu.getName());
        }

        System.out.println("///////////////////////////////////////////////////");

        //字母，数字，中文混合排序--正序
        List<Students> students2 = init();
        Collections.sort(students2, new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                Students newo1 = new Students();
                newo1.setName(PinyinUtils.ToPinyinAndGetFirstChar(o1.getName()));
                Students newo2 = new Students();
                newo2.setName(PinyinUtils.ToPinyinAndGetFirstChar(o2.getName()));
                int i = newo2.getName().substring(0, 1).compareTo(newo1.getName().substring(0, 1));
                return i;
            }
        });
        for(Students stu : students2){
            System.out.println("score:" + stu.getScore() + ":age" + stu.getAge()+":name:"+stu.getName());
        }

        System.out.println("///////////////////////////////////////////////////");

        //正序
        List<Students> students1 = init();
        Collections.sort(students1, new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                return com.ibm.icu.text.Collator.getInstance(com.ibm.icu.util.ULocale.SIMPLIFIED_CHINESE).compare(o1.getName(), o2.getName());
            }
        });
        for(Students stu : students1){
            System.out.println("score:" + stu.getScore() + ":age" + stu.getAge()+":name:"+stu.getName());
        }


        System.out.println("///////////////////////////////////////////////////");

        //倒序
        List<Students> students3 = init();
        Collections.sort(students3, new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                return com.ibm.icu.text.Collator.getInstance(com.ibm.icu.util.ULocale.SIMPLIFIED_CHINESE).compare(o2.getName(), o1.getName());
            }
        });
        for(Students stu : students3){
            System.out.println("score:" + stu.getScore() + ":age" + stu.getAge()+":name:"+stu.getName());
        }


    }

    public static List<Students> init() {
        List<Students> students = new ArrayList<>();
        students.add(new Students(23, 100,"阿里azj001"));
        students.add(new Students(27, 98,"腾讯bzj002"));
        students.add(new Students(29, 99,"百度dzj003"));
        students.add(new Students(29, 98,"华为czj004"));
        students.add(new Students(22, 89,"择天ezj005"));

        students.add(new Students(22, 89,"a择天ezj005"));
        students.add(new Students(22, 89,"A择天ezj005"));
        students.add(new Students(22, 89,"b择天ezj005"));
        students.add(new Students(22, 89,"B择天ezj005"));

        students.add(new Students(22, 89,"8择天ezj005"));
        students.add(new Students(22, 89,"0择天ezj005"));

        students.add(new Students(22, 89,"z择天ezj005"));

        students.add(new Students(22, 89,"_z择天ezj005"));
        return students;
    }
}



