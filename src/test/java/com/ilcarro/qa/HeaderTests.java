package com.ilcarro.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase {
    @BeforeMethod
    public void preconditions(){
       
    }


    @Test
    public void findElements(){
        System.out.println("" + isPresentElements());
    }
    public boolean isPresentElements(){
        try{
            wd.findElements(By.cssSelector("[href=\"/search\"]"));
            return true;
        }catch(NoSuchElementException ex){
            return false;
        }
    }

    public void testsHeader(){
        wd.findElement(By.cssSelector("[href=\"/search\"]")).click();

    }


}
