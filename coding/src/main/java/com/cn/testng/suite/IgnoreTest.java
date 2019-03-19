package com.cn.testng.suite;

import org.testng.annotations.Test;

public class IgnoreTest {
    @Test
    public void ignoreTest(){
        System.out.println("ignoreTest执行");
    }
    @Test(enabled = false)
    public void ignoreTest2(){
        System.out.println("ignoreTest2");
    }
}
