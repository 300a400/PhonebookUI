package com.phonebook.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

    WebDriver driver;
    UserHelper user;
    ContactHelper contact;
    HomePageHelper home;

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        home = new HomePageHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public HomePageHelper getHome() {
        return home;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public UserHelper getUser() {
        return user;
    }
}
