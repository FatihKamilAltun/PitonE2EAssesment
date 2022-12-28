package tests.p2_EventModuleTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.PitonCreateEventPage;
import pages.PitonDashboardPage;
import utilities.Driver;
import utilities.Login;

public class TestCase_1 {
    Login login=new Login();
    PitonDashboardPage pitonDashboardPage=new PitonDashboardPage();
    PitonCreateEventPage pitonCreateEventPage=new PitonCreateEventPage();
    private static Logger logger = LogManager.getLogger(tests.p2_EventModuleTest.TestCase_1.class.getName());

    @Test
    public void test01() {
        login.login();
        logger.info("Kullanici, verilen url'ye gider");
        // Bu adimda utilities package'i altinda olusturulan 'Login' classindaki login methodu,
        // her seferinde giris yapmak icin kullanilacak kodlar yerine kullanilarak clean kod amaclanmistir

        pitonDashboardPage.createEventButton.click();
        logger.info("Kullanici, 'Create Event' butonuna tiklar");

        assert pitonCreateEventPage.createEventTitle.isDisplayed();
        logger.info("Kullanici, acilan sayfada create event formunu gordugunu dogrular");

        Driver.closeDriver();
        logger.info("Kullanici, driver'i kapatir");
    }
}
