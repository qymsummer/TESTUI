package test;

import Case.TestNgCase;
import Case.testcase.LoginCase;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 86135
 */
public class TestNGListenerScreen extends TestListenerAdapter {

    @lombok.SneakyThrows
    @Override
    public void onTestFailure(ITestResult tr){
        System.out.println("这是第一个case失败执行");
        LoginCase tc = (LoginCase)tr.getInstance();
        WebDriver driver = tc.driver;
        this.takeScreenShot(driver);
        super.onTestFailure(tr);
    }

    public void takeScreenShot(WebDriver driver) throws IOException {
        //图片名
        //图片路径
        //获取当前时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String curTime = simpleDateFormat.format(new Date());
        String curClassName = this.getClass().getName();
        String pngPath = curClassName+"_"+curTime+".png";
        //路径
        String curPath = System.getProperty("user.dir");
        System.out.println(curPath);
        //获取当前类名
        File file = ((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(file,new File(curPath+"\\"+pngPath));
    }
}
