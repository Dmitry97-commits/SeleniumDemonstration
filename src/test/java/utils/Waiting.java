package utils;

import pagesSelenium.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waiting extends BasePage {

    static Duration timeOut;

    static {
        try {
            timeOut = Duration.ofSeconds(Integer.parseInt(ResourcesUtils.getResources("configs","timeOut")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static WebDriverWait wait = new WebDriverWait(driver,timeOut);

    public Waiting(WebDriver driver) {
        super(driver);
    }

    public static WebElement byVisible(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement byClicable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static List<WebElement> byVisibleAllElements(List<WebElement> element){
        return wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public static void byStainless(WebElement element){
        wait.until(ExpectedConditions.stalenessOf(element));
    }
}
