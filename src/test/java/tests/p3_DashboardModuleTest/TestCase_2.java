package tests.p3_DashboardModuleTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class TestCase_2 {

    private static Logger logger = LogManager.getLogger(tests.p3_DashboardModuleTest.TestCase_2.class.getName());

    @Test
    public void test02() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        logger.info("Kullanici, verilen url'ye gider");

        String pageUrl = Driver.getDriver().getCurrentUrl();
        logger.info("Kullanici, dogrulama yapmak icin sayfanin url'sini bir String'e atar");

        assert pageUrl.contains("login");
        logger.info("Kullanici, giris yapmadigi icin 'login' sayfasinda oldugunu dogrular");

        Driver.closeDriver();
        logger.info("Kullanici, driver'i kapatir");
    }
}
