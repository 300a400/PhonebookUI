package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DeleteContactTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));
        clickOnLoginButton();

        clickOnAddLink();
        fillContactForm(new Contact()
                .setName("Oliver")
                .setLastName("Adam")
                .setPhone("01234567890")
                .setEmail("Karl@gmail.com")
                .setAddress("Rishon")
                .setDescription("QA"));
        clickOnSaveButton();
    }
    @Test
    public void deleteContactTest(){
        int sizeBefore = sizeOfContacts();
        deleteContact();
        pause(1000);
        int sizeAfter =sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore -1);

    }


}