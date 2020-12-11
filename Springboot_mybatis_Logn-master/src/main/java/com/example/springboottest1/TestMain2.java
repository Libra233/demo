package com.example.springboottest1;

public class TestMain2 {
    public static void main(String[] args) {

        // select * from sys_zdlx where zdywbh ='MJGZZXT'  order by ZDLXBH
        // 找到民警工作子系统，最大编号，然后+1. 比如最新的是JG2019-08211,+1=JG2019-08212
        String itemKey = "JG2019-08272";

        // 需要添加的字典类型名称。
        String itemValue = "违犯是否";

        System.out.println("insert into SYS_ZDLX(id,ZDLXBH,ZDLXMC,ZDLXZT,LJSC,ZDYWBH) " +
                "VALUES(SYS_ZDLX_SEQ.nextval,'"+
                itemKey+"','"+
                itemValue+"',1,0,'MJGZZXT');");




        // 违犯系统的字典项列表。直接复制Oracle的数据，复制过来默认带\n。然后通过分割得出
        String str = "是\n" +
                "否\n";

        String sstr = "0\n" +
                "1\n";

        String[] strArr = str.split("\n");
        String[] sstrArr = sstr.split("\n");
        for (int i =  0 ;i < strArr.length;i++) {
            System.out.println("insert into SYS_ZDSJ (ID,ZDLXBH,ZDJ,LJSC,ZDZ,CODE) VALUES(SYS_ZDSJ_SEQ.nextval,'"+itemKey+"','"+sstrArr[i]+"',0,'"+strArr[i]+"','"+sstrArr[i]+"')"+";");


        }
        System.out.println("/////////////////////////////////yyzcpt");
        System.out.println("insert into SYS_ZDLX(id,ZDLXBH,ZDLXMC,ZDLXZT,LJSC,ZDYWBH) " +
                "VALUES(SYS_ZDLX_SEQ.nextval,'"+
                itemKey+"','"+
                itemValue+"',1,0,'MJGZZXT');");
        for (int i =  0 ;i < strArr.length;i++) {

            System.out.println("insert into SYS_ZDSJ (ID,ZDLXBH,ZDJ,LJSC,ZDZ) VALUES(SYS_ZDSJ_SEQ.nextval,'"+itemKey+"','"+sstrArr[i]+"',0,'"+strArr[i]+"')"+";");


        }
    }
}
