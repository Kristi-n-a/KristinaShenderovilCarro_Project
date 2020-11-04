package com.ilcarro.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.session().isLoginFormPresent()) {
            if(app.session().isUserLoggedIn()){
                app.header().clickLogout();
            }
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() throws InterruptedException {

        app.session().login("Kris-ta@88.com","13Aqqqqqqq");
       // Assert.assertTrue(app.session().isUserLoggedIn());
    }

}