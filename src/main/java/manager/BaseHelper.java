package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseHelper {
    WebDriver wd;

    public BaseHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public boolean isElementPresent(By locator){
        return (wd.findElements(locator).size() > 0);
    }

    public void type(String text, By locator){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

}
