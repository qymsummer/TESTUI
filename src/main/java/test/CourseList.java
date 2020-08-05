package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CourseList {
    public WebDriver driver;
    @BeforeClass
    public void beforeClass() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://coding.imooc.com/");
        Thread.sleep(1);
    }
    @AfterClass
    public void afterClass(){
        driver.close();
    }
/*
    @Test
    public void test01() throws InterruptedException {
        List<String > listStringCourse = ListCourseTitle();
        for (int i=0;i<listStringCourse.size();i++){
           driver.findElement(By.xpath("//p[@title='"+listStringCourse.get(i)+"']")).click();
           driver.navigate().back();
           Thread.sleep(2);
           System.out.println(listStringCourse.get(i));
           System.out.println("这是第一个case");
       }
    }
 */

    @Test
    public void test02() throws InterruptedException {
        Thread.sleep(2);
        List<Integer> numList = GetPageNum();
        for(int i=0;i<numList.size()-1;i++){
            Thread.sleep(1);
            List<WebElement> courseList = driver.findElements(By.className("shizan-name"));
            for(int a=0;a<courseList.size();a++){
                Thread.sleep(1);
                courseList.get(a).click();
                Thread.sleep(1);
                driver.navigate().back();
                Thread.sleep(1);
                courseList = driver.findElements(By.className("shizan-name"));
            }
            driver.findElement(By.partialLinkText("下一页")).click();
            Thread.sleep(10);
        }
    }
/*
    @Test
    public void test03() throws InterruptedException {
        Thread.sleep(2);
        List<WebElement> courseList = driver.findElements(By.className("shizan-name"));
        List<Integer> numList = GetPageNum();
        for(int i=0;i<numList.size()-1;i++){
            for(WebElement courseName : courseList){
                System.out.println(courseName.getText());
                courseName.click();
                driver.navigate().back();
                Thread.sleep(2);
                courseList = driver.findElements(By.className("shizan-name"));
            }
            driver.findElement(By.partialLinkText("下一页"));
        }
    }

 */

    public List<Integer> GetPageNum(){
        List<Integer> pageNumList = new ArrayList<Integer>();
        List<WebElement> aElementList =  driver.findElement(By.className("page")).findElements(By.tagName("a"));
        for (WebElement aElement:aElementList){
            String pageNum = aElement.getText();
            if (isNumber(pageNum) == true){
                pageNumList.add(Integer.valueOf(pageNum).intValue());
                driver.findElement(By.partialLinkText("下一页"));
            }
        }
        return pageNumList;
    }
    public boolean isNumber(String pageNum){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(pageNum);
        if(isNum.matches()){
            return true;
        }
        return false;

    }
    public List<String> ListCourseTitle(){
        List<String> listCourseTitle = new ArrayList<String>();
        List<WebElement> courseList = driver.findElements(By.className("shizan-name"));
        for (WebElement courseName : courseList) {
            String courseTitle = courseName.getText();
            listCourseTitle.add(courseTitle);
        }
        return listCourseTitle;
    }
}
