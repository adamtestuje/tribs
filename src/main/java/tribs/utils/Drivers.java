package tribs.utils;

import org.openqa.selenium.chrome.ChromeDriver;

public class Drivers {
    private static ChromeDriver driver = null;

    public static ChromeDriver chrome() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
