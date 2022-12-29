package tests.p3_DashboardModuleTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.PitonDashboardPage;
import utilities.Driver;
import utilities.Login;

public class TestCase_3 {

    Login login = new Login();
    PitonDashboardPage pitonDashboardPage = new PitonDashboardPage();
    private static Logger logger = LogManager.getLogger(tests.p3_DashboardModuleTest.TestCase_3.class.getName());

    @Test
    public void test03() {
        login.login();
        logger.info("Kullanici, verilen url'ye gider");

        assert pitonDashboardPage.noRegisteredEventText.isDisplayed();
        logger.info("Kullanici, dashboard'da herhangi bir event create edilmedigini dogrular");

        Driver.closeDriver();
        logger.info("Kullanici, driver'i kapatir");
    }
}
