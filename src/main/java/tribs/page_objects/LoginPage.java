package tribs.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tribs.utils.Drivers;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {

    public ChromeDriver driver;

    private By buttonsActiveWorlds = By.className("world_button_active");

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

    public List getWorldsList() {
        List<String> worldsList = new ArrayList<>();
        List<WebElement> activeWorlds = driver.findElements(buttonsActiveWorlds);
        for (WebElement activeWorldButton : activeWorlds) {
            worldsList.add(activeWorldButton.getText().split(" ")[1]);
        }
        return worldsList;
    }
}