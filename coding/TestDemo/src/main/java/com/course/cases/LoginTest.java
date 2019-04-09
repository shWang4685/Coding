package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.utils.ConfigFile;
import org.testng.annotations.BeforeTest;

public class LoginTest {
    /**
     *
     */
    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
    public void  beforeTest(){
        TestConfig.getUserInfoUrl=ConfigFile.getUrl(InterfaceName.GETUSERINFO);

    }
}
