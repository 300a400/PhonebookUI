package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    //login
    @BeforeMethod
    public void precondition(){

        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOut();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));
        app.getUser().clickOnLoginButton();
    }
    @Test
    public void addContactPositiveTest(){
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("Oliver")
                .setLastName("Adam")
                .setPhone("01234567890")
                .setEmail("Karl@gmail.com")
                .setAddress("Rishon")
                .setDescription("QA"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded("Oliver"));
    }

    @AfterMethod
    public void postCondition(){
        app.getContact().deleteContact();

    }

}