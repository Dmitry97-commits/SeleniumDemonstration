package tests;

import PagesSelenide.MainPage;
import PagesSelenide.SubmittingPage;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.RandomUtils;

import java.util.Map;


public class SelenideTests extends BaseTestSelenide{
    MainPage mainPage = new MainPage();

    String name = RandomUtils.RandomString(10);
    String lastName = RandomUtils.RandomString(10);
    String email = String.format("%s@%s.com",RandomUtils.RandomString(5),
            RandomUtils.RandomString(5));
    String gender = "Male";
    String hobbie = "Sports";
    String phoneNumber = RandomStringUtils.randomNumeric(10);

    @Test
    public void FormTest() {
        mainPage
                .closeBanner()
                .sendName(name)
                .sendLastName(lastName)
                .sendEmail(email)
                .enterGender(gender)
                .enterPhoneNumber(phoneNumber)
                .enterHobbie(hobbie)
                .enterBD("18","December","1997")
                .uploadFile()
                //.enterStateAndCity()
                .clickBySubject();


        Map<String,String> dictStudent = SubmittingPage.getStudentInfo();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dictStudent.get("nameStudent"), String.format("%s %s",name,lastName));
        softAssert.assertEquals(dictStudent.get("emailStudent"),email);
        softAssert.assertEquals(dictStudent.get("gender"),gender);
        softAssert.assertEquals(dictStudent.get("mobile"),phoneNumber);
        softAssert.assertEquals(dictStudent.get("hobbies"),hobbie);
        //softAssert.assertEquals(dictStudent.get("picture"),"screenshot.png");
        softAssert.assertAll("Information doesn't match");

    }
}
