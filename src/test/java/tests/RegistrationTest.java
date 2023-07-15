package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends Base{

    @BeforeMethod
    public void preCondition(){
        if (app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void positiveRegistrationTest(){
        int i = (int) ((System.currentTimeMillis()/1000) % 3600);
        String email = "Aa123456" + i + "@gmail.com";
        String password = "$Aa123456";

        User user = User.builder()
                .email(email)
                .password(password)
                .build();

//        wd.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        app.getUser().openLoginRegistrationForm();
//        WebElement email = wd.findElement(By.xpath("//input[contains(@name,'email')]"));
//        email.click();
//        email.clear();
//        email.sendKeys("Aa123456" + i + "@gmail.com");
//        WebElement password = wd.findElement(By.xpath("//input[contains(@name,'password')]"));
//        password.click();
//        password.clear();
//        password.sendKeys("$Aa123456");
        app.getUser().fillRegistrationForm(user);
//        wd.findElement(By.xpath("//button[.='Registration']")).click();
        app.getUser().submitRegistrationForm();

//  waiting to element appears
//        WebDriverWait wait = new WebDriverWait(wd,10);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[.='Sign Out']")));

        app.getUser().pause(5000);
//        List<WebElement> element = wd.findElements(By.xpath("//button[.='Sign Out']"));

        Assert.assertTrue(app.getUser().isLogged());
    }

    @Test
    public void wrongEmail(){
        int i = (int) ((System.currentTimeMillis()/1000) % 3600);
        String email = "Aa123456" + i + "gmail.com";
        String password = "$Aa123456";

        User user = User.builder()
                .email(email)
                .password(password)
                .build();

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitRegistrationForm();

        app.getUser().isCorrectAlertMessage();
        app.getUser().isAlertPresent();

        Assert.assertFalse(app.getUser().isLogged());
    }

    @Test
    public void wrongPassword(){
        int i = (int) ((System.currentTimeMillis()/1000) % 3600);
        String email = "Aa123456" + i + "@gmail.com";
        String password = "Aa123456";

        User user = User.builder()
                .email(email)
                .password(password)
                .build();

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitRegistrationForm();

        app.getUser().isCorrectAlertMessage();
        app.getUser().isAlertPresent();

        Assert.assertFalse(app.getUser().isLogged());
    }

    @AfterMethod
    public void postCondition(){

    }
}
