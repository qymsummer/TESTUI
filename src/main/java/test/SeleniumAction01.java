package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumAction01 {
	public WebDriver driver;
	public void InitDriver() {
		driver = new ChromeDriver();
		driver.get("http://www.imooc.com/user/newlogin/from_url/1005/");
	}
	public void InputElement() {
		WebElement EmailElement = driver.findElement(By.name("email"));
		String UserInfo = EmailElement.getAttribute("placeholder");
		EmailElement.sendKeys("13572562741");
		driver.findElement(By.name("password")).sendKeys("qym11456788");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.className("moco-btn-red")).click();
		//EmailElement.clear();
		System.out.println(UserInfo);
		String Mobile = EmailElement.getAttribute("value");
		boolean info = EmailElement.isDisplayed();
		System.out.println(info);
		System.out.println(Mobile);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.close();
		
	}
	public void Radio() {
		driver.get("https://www.imooc.com/user/setprofile");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.className("js-edit-info")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement UserForm = driver.findElement(By.id("profile"));
		List<WebElement> SexList = UserForm.findElements(By.name("sex"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(WebElement sex:SexList) {
			if(sex.isSelected()) {
				break;
			}else {
				sex.click();
			}
		}
		SexList.get(1).click();
	}
	public void CheckBox(){
		WebElement Box = driver.findElement(By.id("auto-signin"));
		System.out.println(Box.isDisplayed());
		System.out.println(Box.isSelected());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Box.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void Button() {
		WebElement ButtenElement = driver.findElement(By.className("moco-btn-red"));
		System.out.println(ButtenElement.isDisplayed());
		String JsString = "document.getElementsByClassName(\'moco-btn-red\')[0].style.display=\"None\";";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(JsString);
		WebElement ButtenElement1 = driver.findElement(By.className("moco-btn-red"));
		System.out.println(ButtenElement1.isDisplayed());
		
	}
	public void Upfile() {
		driver.get("https://www.imooc.com/user/setbindsns");
		WebElement HeadPng = driver.findElement(By.className("avator-mode"));
		Actions action = new Actions(driver);
		action.moveToElement(HeadPng).perform();
		driver.findElement(By.className("js-avator-link")).click();
		driver.findElement(By.id("upload")).sendKeys("D:\\1111.png");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.close();
		
	}
	public void Upfile_01(){
		driver.get("https://www.imooc.com/user/setbindsns");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement HeadPng = driver.findElement(By.className("avator-img"));
		Actions action = new Actions(driver);
		action.moveToElement(HeadPng).perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.className("js-avator-link")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.className("avator-btn-fake")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Runtime.getRuntime().exec("D:\\auto02.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.className("moco-btn-blue")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Upfile01() throws AWTException {
		driver.get("https://www.imooc.com/user/setbindsns");
		WebElement HeadPng = driver.findElement(By.className("avator-mode"));
		Actions action = new Actions(driver);
		action.moveToElement(HeadPng).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.className("js-avator-link")).click();
		driver.findElement(By.className("avator-btn-fake")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.findElement(By.id("upload")).sendKeys("D:\\1111.png");
		StringSelection selectJpg = new StringSelection("D:\\1111.png");
		Clipboard  sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
		sysc.setContents(selectJpg,null); 	 	
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.className("moco-btn-blue")).click();
		//driver.close();
		
	}
	public void WebForm() {
		WebElement EmailElement = driver.findElement(By.name("email"));
		String UserInfo = EmailElement.getAttribute("placeholder");
		EmailElement.sendKeys("13572562741");
		driver.findElement(By.name("password")).sendKeys("qym11456788");
	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("signup-form")).submit();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	public void SelectOption(){
		driver.get("https://www.imooc.com/user/setprofile");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.className("js-edit-info")).click();
		WebElement UserForm = driver.findElement(By.id("profile"));
		UserForm.findElement(By.id("job")).click();
		List<WebElement> JogList = UserForm.findElements(By.tagName("option"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(JogList.size());
		JogList.get(5).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	public void SelectOptionSelenium() {
		driver.get("https://www.imooc.com/user/setprofile");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.className("js-edit-info")).click();
		WebElement UserForm = driver.findElement(By.id("profile"));
		WebElement Job = UserForm.findElement(By.id("job"));
		Select DownList = new Select(Job);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//DownList.selectByIndex(5);
		DownList.selectByValue("8");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DownList.selectByVisibleText("�������ʦ");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(DownList.isMultiple());
		//DownList.deselectByVisibleText("�������ʦ");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> SelectOption  = DownList.getAllSelectedOptions();
		for(WebElement option:SelectOption) {
			System.out.println(option.getText());
		}
		driver.close();
	}
	public void MoveAction() {
		driver.get("https://www.imooc.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//WebElement LoginElement = driver.findElement(By.id("js-signin-btn"));
		Actions MoseActions = new Actions(driver);
		//MoseActions.click(LoginElement).perform();
		List<WebElement> MenElementList = driver.findElements(By.className("item"));
		WebElement MoblieElement = MenElementList.get(1);
		MoseActions.click(MoblieElement).perform();

		driver.findElement(By.linkText("小程序")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.close();
	}
	public void SwitchIframe(){
		Actions MoseActions = new Actions(driver);
		driver.get("https://www.imooc.com/article/publish#");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			driver.findElement(By.id("ueditor_0"));
		}catch (Exception e){
			System.out.println("定位错误");
		}
		WebElement ifameElement = driver.findElement(By.id("ueditor_0"));
		driver.switchTo().frame(ifameElement);
		WebElement Ueditor = driver.findElement(By.tagName("p"));
		MoseActions.moveToElement(Ueditor).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MoseActions.sendKeys("this is test").perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Ueditor.sendKeys("this is test");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	public void WindowsHandle() throws InterruptedException {
		Thread.sleep(2000);

		Set<String> handles = driver.getWindowHandles();//拿到当前所有窗口
		String CurlHandle =driver.getWindowHandle();//拿当前的窗口
		for(String s: handles) {
			if (s.equals(CurlHandle)) {
				continue;
			} else {
				driver.switchTo().window(s);
			}
		}
		driver.findElement(By.className("shizan-name")).click();
		Thread.sleep(2000);
		driver.close();
	}
	public void AlertWindows(){
		driver.get("");
		//操作弹窗
		driver.findElement(By.id("alert")).click();
		driver.switchTo().alert().accept();//点击确认
		driver.navigate().refresh();//刷新
		//确认弹窗
		driver.findElement(By.id("sure")).click();
		driver.switchTo().alert().dismiss();//点击取消
		driver.navigate().refresh();//刷新
		//弹窗输入框
		driver.findElement(By.id("three")).click();
		driver.switchTo().alert().sendKeys("qym");
		driver.switchTo().alert().accept();
	}
	public void Wait(){
		//隐式等待
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//显示等待
		driver.get("https://www.imooc.com/");
		WebDriverWait webDriverWait = new WebDriverWait(driver,1);

			System.out.println(webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("js-signin-btn"))));

		driver.close();
	}
	public static void main(String[] args) throws AWTException, InterruptedException {

		SeleniumAction01 selenium = new SeleniumAction01();
		selenium.InitDriver();
		//selenium.WebForm();
		//selenium.InputElement();
		//selenium.Radio();
		//selenium.Upfile(); 
		//selenium.Upfile_01();
		//selenium.Button();
		//selenium.CheckBox();
		//selenium.Upfile01();
		//selenium.SelectOption();
		//selenium.SelectOptionSelenium();
		//selenium.MoveAction();
		//selenium.SwitchIframe();
		//selenium.WindowsHandle();
		selenium.Wait();
	}


}
