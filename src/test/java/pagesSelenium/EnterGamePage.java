package pagesSelenium;

import utils.Waiting;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

public class EnterGamePage extends BasePage{
    By prices = By.xpath("//div[@class ='col search_price  responsive_secondrow']");
    By sortingButton = By.id("sort_by_trigger");
    By byDescButton = By.id("Price_DESC");
    By byAscButton = By.id("Price_ASC");

    public EnterGamePage(WebDriver driver) {
        super(driver);
    }

    public EnterGamePage clickSortingButton(){
        Waiting.byClicable(driver.findElement(sortingButton)).click();
        return this;
    }

    public void clickSortingByDesc(){
        Waiting.byVisible(driver.findElement(byDescButton)).click();
        Waiting.byStainless(driver.findElement(prices));
    }

    public void clickSortingByAsc() {
        Waiting.byVisible(driver.findElement(byAscButton)).click();
        Waiting.byStainless(driver.findElement(prices));
    }

    public LinkedList<Double> getListWithPrices(){

        List<WebElement> listWithPrices =Waiting.byVisibleAllElements(driver.findElements(prices));
        LinkedList<Double> prices = new LinkedList<>();

        for (WebElement i:listWithPrices) {
            String newPrice = i.getText().replace("$", "");
            if(NumberUtils.isParsable(newPrice)) {
                prices.add(Double.valueOf(newPrice));
                System.out.println(newPrice);
            }
        }
        return prices;
    }
}
