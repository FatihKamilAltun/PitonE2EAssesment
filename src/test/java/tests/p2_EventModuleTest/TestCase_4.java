package tests.p2_EventModuleTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.PitonCreateEventPage;
import pages.PitonDashboardPage;
import utilities.Driver;
import utilities.Login;
import java.util.List;

public class TestCase_4 {

    Login login = new Login();
    PitonDashboardPage pitonDashboardPage = new PitonDashboardPage();
    PitonCreateEventPage pitonCreateEventPage = new PitonCreateEventPage();
    private static Logger logger = LogManager.getLogger(tests.p2_EventModuleTest.TestCase_4.class.getName());

    @Test
    public void test04() {
        login.login();
        logger.info("Kullanici, verilen url'ye gider");

        pitonDashboardPage.createEventButton.click();
        logger.info("Kullanici, 'Create Event' butonuna tiklar");

        pitonCreateEventPage.addParticipantButton.click();
        pitonCreateEventPage.addParticipantButton.click();
        logger.info("Kullanici, birden fazla kez 'Add Participant' butonuna tiklar");

        List<WebElement> numberOfParticipant= Driver.getDriver().findElements(By.xpath("//tr/td[1]"));
        logger.info("Kullanici, participant sayilarini bir List'e atar");

        for (int i = 1; i <= numberOfParticipant.size() ; i++) {
            pitonCreateEventPage.deleteParticipantButton.click();
        }
        logger.info("Kullanici, for araciligi ile kayitlar silinene kadar delete butonuna tiklar");
        // Bu adimda yukarida List'e atilan participant sayisini size methodu ile alarak for dongusunde o size'e kadar delete butonuna tiklandi
        // Yani sayfanin kendisindeki kayita yukarida goruldugu uzere 2 kez 'Add Participant' butonuna tiklandi ve toplamda 3 adet satir elde edildi
        // for dongusunde de 1'den baslanarak bu List'in size'ina kadar olan sayi kadar delete butonuna tiklandi ve tum kayitlar silindi


        assert pitonCreateEventPage.participantsErrorMessage.isDisplayed();
        logger.info("Kullanici, 'Please add participant!' uyarisinin gorundugunu dogrular");

        Driver.closeDriver();
        logger.info("Kullanici, driver'i kapatir");
    }
}
