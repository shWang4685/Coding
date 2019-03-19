package com.cn.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    @Test
    public void testCase1(){
        System.out.println("testCase1这是测试用例1");
    }
    @BeforeClass
    public void beforeTest(){
        System.out.println("beforeTest这是在测试用例之前运行的");
    }
    @AfterClass
    public void afterTest(){
        System.out.println("afterTest这是在测试用例执行后执行的");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是beforeMethod");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("这是afterMethod");
    }
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("beforeSuit");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");
    }

}
