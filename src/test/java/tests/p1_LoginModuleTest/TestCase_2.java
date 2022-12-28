package tests.p1_LoginModuleTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.PitonLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TestCase_2 {

    PitonLoginPage pitonLoginPage=new PitonLoginPage();
    Actions actions=new Actions(Driver.getDriver());
    private static Logger logger = LogManager.getLogger(TestCase_2.class.getName());
    @Test
    public void test02() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        logger.info("Kullanici, verilen url'ye girer");


        pitonLoginPage.logginButton.click();
        logger.info("Kullanici, bilgileri girmeden login butonuna tiklar");
        // Bu adimda test case'in istedigi sekilde bilgileri girmede login butonuna basildi

        assert pitonLoginPage.usernameErrorText.isDisplayed();
        logger.info("Kullanici, 'Username field is required' yazisinin ciktigini dogruladi");

        assert pitonLoginPage.passwordErrorText.isDisplayed();
        logger.info("Kullanici, 'Password field is required' yazisinin ciktigini dogruladi");

        Driver.closeDriver();
        logger.info("Kullanici, driver'i kapatti");

    }
}
