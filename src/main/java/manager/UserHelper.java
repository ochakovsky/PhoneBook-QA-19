package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//button[.='Sign Out']"));
    }

    public void fillRegistrationForm(String email, String password) {
        type(email, By.xpath("//input[contains(@name,'email')]"));
        type(password, By.xpath("//input[contains(@name,'password')]"));
    }

    public void submitRegistrationForm() {
        click(By.xpath("//button[.='Registration']"));
    }

    public void openLoginRegistrationForm() {
        click(By.xpath("//a[contains(.,'LOGIN')]"));
    }

    public void submitLogin() {
        click(By.xpath("//button[1]"));
    }

    public void fillRegistrationForm(User user) {
        type(user.getEmail(), By.xpath("//input[contains(@name,'email')]"));
        type(user.getPassword(), By.xpath("//input[contains(@name,'password')]"));
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(wd, 5).until(ExpectedConditions.alertIsPresent());
        if (alert == null){
            return false;
        }
        wd.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        return true;
    }

    public boolean isCorrectAlertMessage(){
        String text = "Wrong email or password";
        Alert alert = new WebDriverWait(wd, 5).until(ExpectedConditions.alertIsPresent());
//        alert.getText().compareTo(text);
        return alert.getText().contains(text);
    }
}
