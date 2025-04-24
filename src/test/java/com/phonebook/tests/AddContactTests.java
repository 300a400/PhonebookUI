package com.phonebook.tests;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase{

    //login
    @BeforeMethod
    public void precondition(){

        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOut();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
    }
    @Test
    public void addContactPositiveTest(){
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.FIRST_NAME)
                .setLastName(ContactData.LAST_NAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription(ContactData.DESCRIPTION));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(ContactData.FIRST_NAME));
    }

    @DataProvider
    public Iterator<Object[]>addNewContact(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Twist", "01234567890", "Ntwist@gm.com", "Rishon", "QA"});
        list.add(new Object[]{"Oliver", "Twist", "012345678901", "twist@gm.com", "Rishon", "QA"});
        list.add(new Object[]{"Oliver", "Twist", "01234567890123", "Kwist@gm.com", "Rishon", "QA"});
        return list.iterator();
    }

    @Test(dataProvider = "addNewContact")
    public void addContactPositiveFromDataProviderTest(String name, String lastName, String phone, String email, String address, String description) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.FIRST_NAME)
                .setLastName(ContactData.LAST_NAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription(ContactData.DESCRIPTION));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactAdded(name));
    }

    @AfterMethod
    public void postCondition(){
        app.getContact().deleteContact();

    }

}