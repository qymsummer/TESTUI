package Case.testcase;

import Case.TestNgCase;
import Case.handle.LoginHandle;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import test.TestNGListenerScreen;

import java.io.IOException;
@Listeners(TestNGListenerScreen.class)
public class LoginCase {
    /**
     * （1）
     * 输入正确的邮箱
     * 输入错误密码
     * 点击登陆
     * (2)
     * 输入错误的邮箱
     * 输入错误的密码
     * 点击登录
     */
    static Logger logger = Logger.getLogger(LoginCase.class);
    public WebDriver driver;
    LoginHandle loginHandle;
    @BeforeMethod
    public void beforeClass() throws InterruptedException {
        PropertyConfigurator.configure("C:\\uitest\\src\\main\\resources\\log4j.properties");
        logger.debug("初始化浏览器");
        driver = new ChromeDriver();
        logger.debug("打开浏览器");
        driver.get("https://www.imooc.com");
        Thread.sleep(2000);
        driver.findElement(By.id("js-signin-btn")).click();
        loginHandle = new LoginHandle(driver);
        Thread.sleep(3000);
    }
    @AfterMethod
    public void afterClass() throws InterruptedException {
        driver.close();
    }
    @Test
    public void testLoginSuccess() throws IOException, InterruptedException {
        logger.debug("开始执行第一个case");
        loginHandle.SendEmail("13572562741");
        loginHandle.SendPassWord("qym11456788");
        //loginHandle.clickSenven();
        loginHandle.ClickLogin();
        String userName = loginHandle.GetUserText();
        Assert.assertEquals(userName,"追风筝的人qym");
        System.out.println("----------");
    }
    @Test
    public void testLoginEmailError() throws IOException, InterruptedException {
        logger.debug("开始执行第二个case");
        loginHandle.SendEmail("1231231");
        loginHandle.SendPassWord("qym11456788");
        //loginHandle.clickSenven();
        loginHandle.ClickLogin();
        String userName = loginHandle.GetUserText();
        Assert.assertEquals(userName,"追风筝的人qym");
    }
}