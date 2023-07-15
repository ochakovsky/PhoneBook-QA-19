package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper user;
    public void init(){
        wd = new ChromeDriver();
        user = new UserHelper(wd);
        wd.navigate().to("https://telranedu.web.app/home");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public UserHelper getUser() {
        return user;
    }

    public void tearDown(){
//        wd.quit();
    }
}
