package tribs.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import tribs.utils.Drivers;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private ChromeDriver driver;
    private final By villageName = By.id("menu_row2_village");

    public MainPage() {
        driver = Drivers.chrome();
    }

    public List getVillagesList() {
        List<String> villages = new ArrayList<>();
        villages.add(driver.findElement(villageName).getText());
        return villages;
    }
}
