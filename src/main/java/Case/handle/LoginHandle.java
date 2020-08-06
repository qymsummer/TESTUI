package Case.handle;

import Case.page.LoginPage;
import Case.testcase.LoginCase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

/**
 * @author 86135
 */
public class LoginHandle {
    static Logger logger = Logger.getLogger(LoginHandle.class);
    public LoginPage loginPage;
    public LoginHandle(WebDriver driver){
        loginPage = new LoginPage(driver);
    }
    public void SendEmail(String email) throws IOException, InterruptedException {
        logger.debug("您输入的用户邮箱："+email);
        loginPage.getEmailElement().sendKeys(email);
    }
    public void SendPassWord(String password) throws IOException, InterruptedException {
        logger.debug("您输入的用户密码："+password);
        loginPage.getPassWordElement().sendKeys(password);
    }

    public void ClickSenven() throws IOException, InterruptedException {
        loginPage.getServenElement().click();
    }

    public void ClickLogin() throws IOException, InterruptedException {
        logger.debug("您开始点击登录按钮");
        loginPage.getLoginButtonElement().click();
        Thread.sleep(3000);
    }

    public String GetUserText() throws IOException, InterruptedException {
        loginPage.MoveToElement(loginPage.getUsePngElement());
        String username = loginPage.getUseInfoElement().getText();
        return username;
    }

    public void ClickSiginButton() throws IOException, InterruptedException {
        loginPage.getSigninButtonElement().click();
        Thread.sleep(3000);
    }

}
