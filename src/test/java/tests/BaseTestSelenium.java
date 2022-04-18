package tests;

import utils.ResourcesUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTestSelenium {
    WebDriver driver;

    @BeforeClass
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setupTest() throws Exception {
        driver = new ChromeDriver();
        driver.get(ResourcesUtils.getResources("configs","baseUrlForSeleniumTests"));
    }

    @AfterMethod
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
