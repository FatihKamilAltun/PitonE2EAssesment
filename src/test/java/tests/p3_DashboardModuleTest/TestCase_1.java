package tests.p3_DashboardModuleTest;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.PitonCreateEventPage;
import pages.PitonDashboardPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Login;

public class TestCase_1 {

    Login login = new Login();
    PitonDashboardPage pitonDashboardPage = new PitonDashboardPage();
    PitonCreateEventPage pitonCreateEventPage = new PitonCreateEventPage();
    Faker faker = new Faker();
    private static Logger logger = LogManager.getLogger(tests.p3_DashboardModuleTest.TestCase_1.class.getName());

    @Test
    public void test01() {
        login.login();
        logger.info("Kullanici, verilen url'ye gider");

        String pageUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(pageUrl);

        assert pageUrl.contains("dashboard");
        logger.info("Kullanici, 'dashboard'da oldugunu sayfanin url'sinden dogrular");

        Driver.closeDriver();
        logger.info("Kullanici, driver'i kapatir");

    }
}
