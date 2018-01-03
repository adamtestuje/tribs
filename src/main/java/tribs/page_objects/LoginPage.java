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
        worldsList.add("Test");
        System.out.println("Worlds: ");
        System.out.println(driver.findElements(By.className("world_button_active")));
//        for (WebElement activeWorldButton : allActiveWorldButtons) {
//            worldsList.add(activeWorldButton.getText());
//        }
        return worldsList;
    }
}