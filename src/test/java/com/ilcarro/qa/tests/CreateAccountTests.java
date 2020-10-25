package com.ilcarro.qa.tests;

import com.ilcarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    //preconditions: user shoud be logged out
    @BeforeMethod
    public void ensurePreconditions() {
        if (!isSignUpTabPresentInHeader()) {    //sign up not present
            logOut();
        }
    }

    @Test
    public void testSignUp() throws InterruptedException {
        //click On SignUp button
        openRegistrationFormFromHeader();
        Assert.assertTrue(isRegistrationFormOpened());
        fillRegistrationForm(
                new User()
                        .setfName("LS")
                        .setlName("DV")
                        .setEmail("Kris@88.com")
                        .setPassword("13Aqqqqqqq"));

        selectPolicyCheckBox();
        pause(2000);
        submitForm();

        //check, login form displayed
        Assert.assertTrue(isLoginFormPresent());
    }


    @Test
    public void negativeTestSignUpWithoutPassword() throws InterruptedException {
        //click On SignUp button
        openRegistrationFormFromHeader();
        Assert.assertTrue(isRegistrationFormOpened());

        fillRegistrationForm(new User()
                .setfName("Vkra")
                .setlName("Kfds")
                .setEmail("vwer.kits1@gmail.com"));

        selectPolicyCheckBox();
        pause(3000);
        //click submit button
        submitForm();
        //check, login form displayed
        Assert.assertFalse(isLoginFormPresent());
    }


}
