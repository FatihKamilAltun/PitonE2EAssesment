package tests.p3_DashboardModuleTest;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.PitonCreateEventPage;
import pages.PitonDashboardPage;
import pages.PitonEditEventPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Login;

public class TestCase_4 {
    Login login = new Login();
    PitonDashboardPage pitonDashboardPage = new PitonDashboardPage();
    PitonCreateEventPage pitonCreateEventPage = new PitonCreateEventPage();
    PitonEditEventPage pitonEditEventPage=new PitonEditEventPage();
    Faker faker = new Faker();
    SoftAssert softAssert=new SoftAssert();
    private static Logger logger = LogManager.getLogger(tests.p3_DashboardModuleTest.TestCase_4.class.getName());

    @Test
    public void test04() {
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

        pitonDashboardPage.editEventButton.click();
        logger.info("Kullanici, 'Edit Event' butonuna tiklar");

        assert pitonEditEventPage.editEventTitle.isDisplayed();
        logger.info("Kullanici, 'Edit Event' sayfasina yonlendirildigini dogrular");

        Driver.closeDriver();
        logger.info("Kullanici, driver'i kapatir");
    }
}
