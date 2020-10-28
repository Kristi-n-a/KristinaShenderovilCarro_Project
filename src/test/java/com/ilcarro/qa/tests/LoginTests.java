package com.ilcarro.qa.tests;

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
        //aa@bb109.com
        //aa@bb110.com
        //fillLoginForm
        app.session().login("Kris@88.com","13Aqqqqqqq");
        //Assert userLoggedIn
    }

}