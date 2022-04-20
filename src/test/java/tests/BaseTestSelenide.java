package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ResourcesUtils;

import static com.codeborne.selenide.Selenide.open;

public class BaseTestSelenide {
    @BeforeMethod
    public void setUp() throws Exception {
        open(ResourcesUtils.getResources("configs","baseUrlForSelenideTests"));
    }

    @AfterMethod
    public void TearDown(){
        Selenide.closeWebDriver();
    }
}
