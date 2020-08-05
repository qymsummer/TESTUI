package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import util.ProUtil;
import java.io.IOException;
import org.testng.annotations.Test;

public class SeleniumMaven {

    public WebDriver driver;
    public void initDriver(){
        driver = new ChromeDriver();
        driver.get("http://www.imooc.com/user/newlogin/from_url/1005/");
    }
    @Test
    public void userLogin() throws InterruptedException, IOException {

        ProUtil pro = new ProUtil("C:\\uitest\\src\\main\\resources\\user.properties");
        int lines = pro.getLines();
        String locator = null;
        String locatorName;
        String locatorPassword;
        for(int i=0;i<lines;i++){
            initDriver();
            locator = pro.getPro("user"+i);
            System.out.println(locator);
            locatorName = locator.split(">")[0];
            locatorPassword = locator.split(">")[1];
            WebElement emailElement = getElement("username");
            WebElement passWordElement = getElement("password");
            WebElement loginButtonElement = getElement("loginbutton");
            emailElement.sendKeys(locatorName);
            passWordElement.sendKeys(locatorPassword);
            loginButtonElement.click();
            Thread.sleep(4000);
            try {
                WebElement userPng = getElement("headpng");
                Actions moseActions = new Actions(driver);
                moseActions.moveToElement(userPng).perform();
                String userTextName = getElement("userinfo").getText();
                System.out.println(userTextName);
                if(userTextName.equals("追风筝的人qym")){
                    System.out.println("登录成功");
                }else {
                    System.out.println("用户信息不匹配");
                }
                System.out.println("登录成功");
            }catch (Exception e){
                System.out.println("登录失败");
            }
            driver.close();
        }


    }
    public By getByLocal(String key) throws IOException {
        ProUtil pro = new ProUtil("C:\\uitest\\src\\main\\resources\\element.properties");
        String locator = pro.getPro(key);
        String locatorBy = locator.split(">")[0];
        String locatorValue = locator.split(">")[1];

        if(locatorBy.equals("id")){
            return By.id(locatorValue);
        }else if(locatorBy.equals("name")){
            return By.name(locatorValue);
        }else if(locatorBy.equals("ClassName")){
            return By.className(locatorValue);
        }else {
            return By.xpath(locatorValue);
        }
    }

    public WebElement getElement(String key) throws IOException {
        WebElement element = driver.findElement(this.getByLocal(key));
        return element;
    }

}
