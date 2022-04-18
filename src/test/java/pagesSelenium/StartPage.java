package pagesSelenium;

import utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

public class StartPage extends BasePage{

    By nameField = By.id("store_nav_search_term");

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public EnterGamePage enterText(String text) {
        Waiting.byVisible(driver.findElement(nameField)).click();
        driver.findElement(nameField).sendKeys(text + Keys.ENTER);
        return new EnterGamePage(driver);
    }

}
