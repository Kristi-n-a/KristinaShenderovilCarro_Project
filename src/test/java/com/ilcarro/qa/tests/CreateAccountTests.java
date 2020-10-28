package com.ilcarro.qa.tests;

import com.ilcarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase {
    //preconditions: user shoud be logged out
    @DataProvider
    public Iterator<Object[]> validUser(){
        List<Object[]>list = new ArrayList<>();
        list.add(new Object[]{"fName","lName","mnBv@gmail.com","11Zxxxxxxx"});
        list.add(new Object[]{"Kr","Sh","3Kj0@aa.com","34Fggggggg"});
        list.add(new Object[]{"Jl","As","sDfaru@zz.com","92Zxxxxxxxx"});

        return list.iterator();
    }

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
                .setfName("LG")
                .setlName("HS")
                .setEmail("Kastra@sh115.com")
                .setPassword("12Xaaaaaaa"));

        //click submit button
        app.session().submitForm();

        //check, login form displayed
        Assert.assertTrue(app.session().isLoginFormPresent());
    }
    @Test(dataProvider = "validUser")
    public void testSignUpFromDataProvider(String fName,
                                           String lName,
                                           String Email,
                                           String Password) throws InterruptedException {
        app.header().clickSignUp();
        app.session().fillRegistrationForm(new User()
                .setfName(fName)
                .setlName(lName)
                .setEmail(Email)
                .setPassword(Password));

        //click submit button
        app.session().submitForm();

        //check, login form displayed
       logger.info("Login form present. actual result: "+app.session().isLoginFormPresent()
        +" expected result is : true");
        Assert.assertTrue(app.session().isLoginFormPresent());

    }


}

