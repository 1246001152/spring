package com.java.javacase;

public class Test {


    public static void main(String[] args) {
        /**
         * 主管命令：测试员进行测试工作
         * 这里将测试控制权交给主管，不需要在业务层改动
         */
        JavaWork javaWork = new JavaWork();
//        javaWork.setTester(new Zhangsan());
        javaWork.setTester(new Lisi());
        javaWork.doTest();


    }
}
