package tests.p2_EventModuleTest;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.PitonCreateEventPage;
import pages.PitonDashboardPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Login;

public class TestCase_5 {

    Login login = new Login();
    PitonDashboardPage pitonDashboardPage = new PitonDashboardPage();
    PitonCreateEventPage pitonCreateEventPage = new PitonCreateEventPage();
    Faker faker = new Faker();
    private static Logger logger = LogManager.getLogger(tests.p2_EventModuleTest.TestCase_5.class.getName());

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

        pitonCreateEventPage.eventDateBox.sendKeys("11/01/2023");
        logger.info("Kullanici, 'Event Date' kismina bilgi girisi yapar");

        pitonCreateEventPage.firstNameBox.sendKeys(faker.name().firstName());
        logger.info("Kullanici, 'First Name' kismina bilgi girisi yapar");
        // Bu adimda her seferinde yeni bir isim bilgisi uretmekle ugrasmamak adina Faker class'i kullanilmistir

        pitonCreateEventPage.lastNameBox.sendKeys(faker.name().lastName());
        logger.info("Kullanici, 'Last Name' kismina bilgi girisi yapar");
        // Bu adimda her seferinde yeni bir soyisim bilgisi uretmekle ugrasmamak adina Faker class'i kullanilmistir

        pitonCreateEventPage.contactBox.sendKeys(faker.internet().emailAddress());
        logger.info("Kullanici, 'Contact' kismina bilgi girisi yapar");
        // Bu adimda her seferinde yeni bir mail adresi bilgisi uretmekle ugrasmamak adina Faker class'i kullanilmistir

        pitonCreateEventPage.createNewEventButton.click();
        logger.info("Kullanici, 'Create New Event' butonuna tiklar");

        String pageSources = Driver.getDriver().getPageSource();
        logger.info("Kullanici, yeni event olusturulduktan sonra gelen dashboard'in tum kodlarini String bir container'a atar");

        assert pageSources.contains("Event created successfully");
        logger.info("Kullanici, sayfanin tum kodlarinda 'Event created successfully' mesajinin icerdigini dogrular");

        Driver.closeDriver();
        logger.info("Kullanici, driver'i kapatir");
    }
}
