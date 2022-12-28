package tests.p3_DashboardModuleTest;

import com.github.javafaker.Faker;
import com.github.javafaker.Weather;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.PitonCreateEventPage;
import pages.PitonDashboardPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Login;

import java.util.List;

public class TestCase_5 {
    Login login = new Login();
    PitonDashboardPage pitonDashboardPage = new PitonDashboardPage();
    PitonCreateEventPage pitonCreateEventPage = new PitonCreateEventPage();
    Faker faker = new Faker();
    SoftAssert softAssert=new SoftAssert();
    private static Logger logger = LogManager.getLogger(tests.p3_DashboardModuleTest.TestCase_5.class.getName());

    @Test
    public void test05() {
        login.login();
        logger.info("Kullanici, verilen url'ye gider");

        pitonDashboardPage.createEventButton.click();
        logger.info("Kullanici, 'Create Event' butonuna tiklar");

        pitonCreateEventPage.eventNameBox.sendKeys(ConfigReader.getProperty("eventName1"));
        logger.info("Kullanici, 'Event Name' kismina bilgi girisi yapar");

        pitonCreateEventPage.eventDescriptionBox.sendKeys(ConfigReader.getProperty("eventDescription1"));
        logger.info("Kullanici, 'Event Description' kismina bilgi girisi yapar");

        pitonCreateEventPage.eventDateBox.sendKeys("2023");
        logger.info("Kullanici, 'Event Date' kismina bilgi girisi yapar");

        pitonCreateEventPage.firstNameBox.sendKeys(faker.name().firstName());
        String firstName=pitonCreateEventPage.firstNameBox.getText();
        logger.info("Kullanici, 'First Name' kismina bilgi girisi yapar ve girilen ismi bir container'e atar");

        pitonCreateEventPage.lastNameBox.sendKeys(faker.name().lastName());
        logger.info("Kullanici, 'Last Name' kismina bilgi girisi yapar");

        pitonCreateEventPage.contactBox.sendKeys(faker.internet().emailAddress());
        logger.info("Kullanici, 'Contact' kismina bilgi girisi yapar");

        pitonCreateEventPage.createNewEventButton.click();
        logger.info("Kullanici, 'Create New Event' butonuna tiklar");

        List<WebElement> titles= Driver.getDriver().findElements(By.xpath("//tr/th"));
        List<String> titlesTexts=null;
        for (WebElement w:titles
             ) {
            System.out.println(w.getText());
            titlesTexts.add(w.getText());
        }
        logger.info("Kullanici, create edilmis event'in basliklarini yazdirir");

        System.out.println(titlesTexts);

        //pitonDashboardPage.deleteEventButton.click();
        logger.info("Kullanici, 'Delete' butonuna tiklar");


    }
}