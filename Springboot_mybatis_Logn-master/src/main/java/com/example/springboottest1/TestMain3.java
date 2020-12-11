package com.example.springboottest1;

public class TestMain3 {
    public static void main(String[] args) {



        // 违犯系统的字典项列表。直接复制Oracle的数据，复制过来默认带\n。然后通过分割得出
        String str = "ZYBH,JSBH,BJBH,SKSJ,SKKM,SKR,SKDD,NRJS,NSRS,NVSRS,ZRS,KSQK,JLR,SJC";

        String[] strArr = str.split(",");
        for (String ii : strArr) {
            System.out.println(ii);
        }
    }
}
