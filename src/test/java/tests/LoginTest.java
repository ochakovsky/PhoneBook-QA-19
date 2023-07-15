package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Base{

    @BeforeMethod
    public void preCondition(){
        if (app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void loginPositive(){
        String email = "abc@def.com";
        String password = "$Abcdef12345";
//        User user = new User().withEmail(email).withPassword(password);

        User user = User.builder()
                .email(email)
                .password(password)
                .build();
        app.getUser().openLoginRegistrationForm();
//        app.getUser().fillRegistrationForm(email, password);
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();

       // pause(5000);
        Assert.assertTrue(app.getUser().isLogged());
    }

    @Test
    public void loginNegativeEmail(){
        String email = "abcdef.com";
        String password = "$Abcdef12345";

        User user = User.builder()
                .email(email)
                .password(password)
                .build();

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();

        app.getUser().isCorrectAlertMessage();
        app.getUser().isAlertPresent();
        Assert.assertFalse(app.getUser().isLogged());
    }

    @Test
    public void loginNegativePassword(){
        String email = "abc@def.com";
        String password = "Abcdef12345";

        User user = User.builder()
                .email(email)
                .password(password)
                .build();

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();

        app.getUser().isCorrectAlertMessage();
        app.getUser().isAlertPresent();
        Assert.assertFalse(app.getUser().isLogged());
    }

    @AfterMethod
    public void postCondition(){

    }
}
