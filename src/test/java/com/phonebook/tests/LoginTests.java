package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTest() {

        clickOnLoginLink();
        fillRegisterLoginForm("joe1@test.com", "Aa12345$");
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonIsPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setPassword("Nnoa12345$"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertDisplayed());
    }
}