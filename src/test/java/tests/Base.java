package tests;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class Base {

    public static ApplicationManager app = new ApplicationManager();
    @BeforeSuite
    public void setup(){
        app.init();
    }

    @AfterSuite
    public void stop(){
        //app.tearDown();
    }
}
