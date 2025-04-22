package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOut();
        }
    }

    @Test
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail("joe@test.com").setPassword("Qwea12345$"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setPassword("Nnoa12345$"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }
}