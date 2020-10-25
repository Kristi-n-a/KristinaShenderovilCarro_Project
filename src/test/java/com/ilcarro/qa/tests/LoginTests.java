package com.ilcarro.qa.tests;

import com.ilcarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    //tests for logintn
    @BeforeMethod
    public void ensurePreconditions() {
        if (!isLoginFormPresent()) {
            if(isUserLoggedIn()){
                logOut();
            }
            clickLoginTabOnHeader();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        //aa@bb109.com
        //aa@bb110.com

        fillLoginForm(new User().setEmail("Kris@88.com").setPassword("13Aqqqqqqq"));

        submitForm();
        Assert.assertTrue(isUserLoggedIn());
        String email = getEmailTextFromHeader();
        System.out.println(email);
        Assert.assertEquals(email, "Kris@88.com");


    }

}
