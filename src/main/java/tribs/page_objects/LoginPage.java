package tribs.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import tribs.utils.Drivers;

public class LoginPage {

    public ChromeDriver driver;

    public LoginPage() {
        driver = Drivers.chrome();
    }

    public void loginAs(String login, String password) {
        driver.navigate().to("https://www.tribalwars.net/");
        driver.findElement(By.id("user")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.linkText("Login")).click();
    }

    public boolean isLogged() {
        return driver.getPageSource().contains("Welcome, ");
    }
}
