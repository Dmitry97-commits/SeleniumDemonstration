package tests;

import pagesSelenium.EnterGamePage;
import pagesSelenium.StartPage;
import utils.ResourcesUtils;
import utils.SortingUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumTests extends BaseTestSelenium {

    @Test
    void firstTest() throws Exception {
        StartPage startPage = new StartPage(driver);
        EnterGamePage enterGamePage = new EnterGamePage(driver);
        startPage
                .enterText(ResourcesUtils.getResources("configs","nameOfFirstGame"))
                .clickSortingButton()
                .clickSortingByDesc();

        List<Double> listWithPrices = enterGamePage.getListWithPrices();
        Assert.assertTrue(SortingUtils.isSortedBy(listWithPrices,"Desc"),"List didn't sorted by desc");
    }

    @Test
    void secondTest() throws Exception {
        StartPage startPage = new StartPage(driver);
        EnterGamePage enterGamePage = new EnterGamePage(driver);
        startPage
                .enterText(ResourcesUtils.getResources("configs","nameOfSecondGame"))
                .clickSortingButton()
                .clickSortingByAsc();

        List<Double> listWithPrices = enterGamePage.getListWithPrices();
        Assert.assertTrue(SortingUtils.isSortedBy(listWithPrices,"Asc"),"List didn't sorted by asc");
    }


}
