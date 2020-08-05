package Case.handle;

import Case.page.LoginPage;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

/**
 * @author 86135
 */
public class LoginHandle {
    public LoginPage loginPage;
    public LoginHandle(WebDriver driver){
        loginPage = new LoginPage(driver);
    }
    public void SendEmail(String email) throws IOException, InterruptedException {
        loginPage.getEmailElement().sendKeys(email);
    }
    public void SendPassWord(String password) throws IOException, InterruptedException {
        loginPage.getPassWordElement().sendKeys(password);
    }

    public void ClickSenven() throws IOException, InterruptedException {
        loginPage.getServenElement().click();
    }

    public void ClickLogin() throws IOException, InterruptedException {
        loginPage.getLoginButtonElement().click();
        Thread.sleep(3000);
    }

    public String GetUserText() throws IOException, InterruptedException {
        loginPage.MoveToElement(loginPage.getUsePngElement());
        String username = loginPage.getUseInfoElement().getText();
        return username;
    }
}
