package com.java.javacase;

public class JavaWork {

    private Tester tester;

    public void setTester(Tester tester) {
        this.tester = tester;
    }

    public void doTest(){
//        代码业务耦合度比较高
//        Zhangsan zhangsan  = new Zhangsan();
//        zhangsan.test();
        tester.test();
    }
}
