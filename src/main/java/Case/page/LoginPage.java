package Case.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * @author 86135
 */
public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * 获取 邮箱元素
     * 获取 密码元素
     * 获取 7天登陆元素
     * 获取 登陆按钮元素
     */
    public WebElement getEmailElement() throws IOException, InterruptedException {
        return getElement("username");
    }

    public WebElement getPassWordElement() throws IOException, InterruptedException {
        return getElement("password");
    }

    public WebElement getServenElement() throws IOException, InterruptedException {
        return getElement("serven");
    }

    public WebElement getLoginButtonElement() throws IOException, InterruptedException {
        return getElement("loginbutton");
    }

    public WebElement getUsePngElement() throws IOException, InterruptedException {
        return getElement("headpng");
    }

    public WebElement getUseInfoElement() throws IOException, InterruptedException {
        return getElement("userinfo");
    }

    public WebElement getSigninButtonElement() throws IOException, InterruptedException {
        return getElement("signinbutton");
    }

}
