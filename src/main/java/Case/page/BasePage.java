package Case.page;

import Case.testcase.LoginCase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.MouseAction;
import util.ProUtil;

import java.io.IOException;

/**
 * @author 86135
 */
public class BasePage {
    public WebDriver driver;
    static Logger logger = Logger.getLogger(LoginCase.class);
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getElement(String key) throws IOException, InterruptedException {
        Thread.sleep(500);
        WebElement element = driver.findElement(this.getByLocal(key));
        return element;
    }
    public By getByLocal(String key) throws IOException {
        ProUtil pro = new ProUtil("C:\\uitest\\src\\main\\resources\\element.properties");
        logger.debug("你得到定位信息Key为:"+key);
        String locator = pro.getPro(key);
        String locatorBy = locator.split(">")[0];
        String locatorValue = locator.split(">")[1];
        logger.debug("你得到定位方式为:"+locatorBy);
        logger.debug("你得到定位值为:"+locatorValue);
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
    public void MoveToElement(WebElement toelement) throws IOException, InterruptedException {
        Actions moveActions = new Actions(driver);
        moveActions.moveToElement(toelement).perform();
    }

}
