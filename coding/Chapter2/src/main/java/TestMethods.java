import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethods {
    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }
    @Test
    public void test2(){
        Assert.assertEquals("aaa","aaa");
    }
    @Test
    public void test4(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test3(){
        Reporter.log("自己写的日志");
        throw new RuntimeException("这是写的异常");


    }
}
