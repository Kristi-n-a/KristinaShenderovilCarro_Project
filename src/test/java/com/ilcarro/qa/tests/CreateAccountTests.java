package com.ilcarro.qa.tests;
import com.ilcarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase {
    //preconditions: user shoud be logged out


    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.header().isSignUpTabPresentInHeader()) {    //sign up not present
            app.header().clickLogout();
        }
    }

    @Test
    public void testSignUp() throws InterruptedException {
        app.header().clickSignUp();
        app.session().fillRegistrationForm(new User()
                .setfName("Kr")
                .setlName("Sh")
                .setEmail("Kris88@aa.com")
                .setPassword("13Aqqqqqqq"));

        //click submit button
        app.session().submitForm();

        //check, login form displayed
        Assert.assertTrue(app.session().isLoginFormPresent());
        logger.info(String.valueOf(app.session().isLoginFormPresent()));
    }

    @Test(dataProvider = "validUser", dataProviderClass = DataProvider.class)
    public void testSignUpFromDataProvider(
            String fName, String lName, String email, String password ) throws InterruptedException {
        app.header().clickSignUp();
        app.session().fillRegistrationForm(new User()
                .setfName(fName)
                .setlName(lName)
                .setEmail(email)
                .setPassword(password));

        //click submit button
        app.session().submitForm();

        logger.info("Login form present. actual result: "+ app.session().isLoginFormPresent()
                + " expected result is: true ");
        //check, login form displayed
        Assert.assertTrue(app.session().isLoginFormPresent());

    }

    @Test(dataProvider = "validUserFromCSV", dataProviderClass = DataProvider.class)
    public void testSignUpFromCSVDataProvider(User user) throws InterruptedException {
        app.header().clickSignUp();
        app.session().fillRegistrationForm(user);
        //click
        app.session().submitForm();

        logger.info("Login form present. actual result: "+ app.session().isLoginFormPresent()
                + " expected result is: true ");
        //check, login form displayed
        Assert.assertTrue(app.session().isLoginFormPresent());

    }


}