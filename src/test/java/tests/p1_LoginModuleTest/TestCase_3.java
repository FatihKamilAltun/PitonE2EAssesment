package tests.p1_LoginModuleTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.PitonDashboardPage;
import pages.PitonLoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TestCase_3 {

    PitonLoginPage pitonLoginPage = new PitonLoginPage();
    PitonDashboardPage pitonDashboardPage=new PitonDashboardPage();
    Actions actions = new Actions(Driver.getDriver());
    private static Logger logger = LogManager.getLogger(TestCase_3.class.getName());
    @Test
    public void test03() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        logger.info("Kullanici, verilen url'ye gider");

        pitonLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("username"));
        logger.info("Kullanici, username'i girer");
        // configuration.properties araciligi ile bu adimda onceden belirlenen gecerli username dinamik hale getirilerek giris saglandi

        pitonLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        logger.info("Kullanici, password'u girer");
        // configuration.properties araciligi ile bu adimda onceden belirlenen gecerli password dinamik hale getirilerek giris saglandi

        pitonLoginPage.logginButton.click();
        logger.info("Kullanici, login butonuna tiklar");

        assert pitonDashboardPage.welcomeText.isDisplayed();
        logger.info("Kullanici, basarili bir sekilde giris yaptigini dogrular");
        // Gelinen sayfada 'Welcome Automation Test User' yazisinin gorulmesi basarili bir sekilde giris yapildigini dogrulamaktadir

        Driver.closeDriver();
        logger.info("Kullanici, driver'i kapatir");
    }
}
