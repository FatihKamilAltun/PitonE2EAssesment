package tests.p1_LoginModuleTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.PitonLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TestCase_1 {

    PitonLoginPage pitonLoginPage=new PitonLoginPage();
    private static Logger logger = LogManager.getLogger(TestCase_1.class.getName());
    @Test

    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        logger.info("Kullanici, verilen url'ye gider");
        // Bu adimda configuration.properties dosyasi kullanilarak kod daha dinamik hale getirildi

        assert pitonLoginPage.loginPageTitle.isDisplayed();
        logger.info("Kullanici, acilan sayfada login formu ile karsilastigini dogrular");

        assert pitonLoginPage.usernameBox.isDisplayed();
        logger.info("Kullanici, 'username' kutusunun oldugunu dogrular");

        assert pitonLoginPage.passwordBox.isDisplayed();
        logger.info("Kullanici, 'password' kutusunun oldugunu dogrular");

        assert pitonLoginPage.logginButton.isDisplayed();
        logger.info("Kullanici, 'login' butonunun oldugunu dogrular");
        // assert araciligi ile formun basligi, username, password ve login kisimlarinin goruntulenebildigi dogrulandi

        Driver.closeDriver();
        logger.info("Kullanici, driver'i kapatir");
    }
}
