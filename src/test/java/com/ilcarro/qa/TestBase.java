package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public void isFindFormPresent(){
        //return  isFindCarFormPresent(By.cssSelector(".Main_mainpage__find_your_car__AHLkw"));
    }

    public boolean isFindCarFormPresent(){
        return wd.findElements(By.cssSelector(".Main_mainpage__find_your_car__AHLkw")).size()>0;
    }

    public boolean isFindCarFormPresent2(){
        try{
            wd.findElements(By.cssSelector(".Main_mainpage__find_your_car__AHLkw"));
            return true;
        } catch(NoSuchElementException ex){
            return false;
        }
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        wd.quit();
    }
}
