package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverManager {
    private static WebDriver driver;
    private static String browser;
    private static String url;

    static {
        try {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);
            browser = prop.getProperty("browser");
            url = prop.getProperty("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            assert driver != null;
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static String getURL() {
        return url;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
