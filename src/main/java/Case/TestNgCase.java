package Case;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.mail.SimpleEmail;
import org.testng.Assert;
import org.testng.annotations.*;
import test.TestNGListenerScreen;

@Listeners(TestNGListenerScreen.class)
public class TestNgCase {

    private static Logger logger = Logger.getLogger(TestNgCase.class);
    public WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.get("http://www.imooc.com/user/newlogin/from_url/1005/");
    }
    @AfterTest
    public void afterClass() throws EmailException {
        driver.close();
        sendEmail();
    }
    public void sendEmail() throws EmailException {
        SimpleEmail simpleEmail = new SimpleEmail();
        simpleEmail.setHostName("smtp.mxhichina.com");
        simpleEmail.setAuthentication("qym@dataqin.com",
                "Qym5633~");
        simpleEmail.setFrom("qym@dataqin.com");
        simpleEmail.addTo("qym@dataqin.com");
        simpleEmail.setSubject("selenium");
        simpleEmail.setMsg("this is test");
        simpleEmail.send();
       logger.debug("发送成功");
    }

    @Test
    public void test01() throws InterruptedException {
        logger.debug("邮箱信息");
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys("13572562741");
        Assert.assertEquals(1,2);
        System.out.println("第一个case");
    }
    @Test
    public void test02() throws InterruptedException {
        logger.error("错误的email");
        Thread.sleep(1000);
        driver.findElement(By.id("email1")).sendKeys("13572562741");
        System.out.println("第二个case");
    }
    @Test
    public void test03() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("13572562741");
        System.out.println("第三个case");
    }
    @Test
    public void test04() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.name("password1")).sendKeys("13572562741");
        System.out.println("第四个case");
    }
    @Test
    public void test05() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.className("moco-btn-red")).click();
        System.out.println("第五个case");
    }
}
