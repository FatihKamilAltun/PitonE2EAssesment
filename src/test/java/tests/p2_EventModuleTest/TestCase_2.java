package tests.p2_EventModuleTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.PitonCreateEventPage;
import pages.PitonDashboardPage;
import utilities.Driver;
import utilities.Login;

public class TestCase_2 {

    Login login = new Login();
    PitonDashboardPage pitonDashboardPage = new PitonDashboardPage();
    PitonCreateEventPage pitonCreateEventPage = new PitonCreateEventPage();
    private static Logger logger = LogManager.getLogger(tests.p2_EventModuleTest.TestCase_2.class.getName());

    @Test
    public void test02() {
        login.login();
        logger.info("Kullanici, verilen url'ye gider");

        pitonDashboardPage.createEventButton.click();
        logger.info("Kullanici, 'Create Event' butonuna tiklar");

        pitonCreateEventPage.createNewEventButton.click();
        logger.info("Kullanici, 'Create New Event' butonuna tiklar");
        // Bu adimda test case'in istedigi sekilde bilgiler girilmeden 'Create New Event' butonuna tiklandi

        assert pitonCreateEventPage.eventNameErrorText.isDisplayed();
        logger.info("Kullanici, 'Event name field is required' yazisinin ciktigini dogrular");

        assert pitonCreateEventPage.eventDateErrorText.isDisplayed();
        logger.info("Kullanici, 'Please choose a valid date' yazisinin ciktigini dogrular");

        assert pitonCreateEventPage.participantNameErrorText.isDisplayed();
        logger.info("Kullanici, 'Participant name is required' yazisinin ciktigini dogrular");

        assert pitonCreateEventPage.participantLastNameErrorText.isDisplayed();
        logger.info("Kullanici, 'Participant last name is required' yazisinin ciktigini dogrular");

        assert pitonCreateEventPage.emailOrPhoneErrorText.isDisplayed();
        logger.info("Kullanici, 'Please enter email or phone number' yazisinin ciktigini dogrular");

        Driver.closeDriver();
        logger.info("Kullanici, driver'i kapatir");
    }
}
