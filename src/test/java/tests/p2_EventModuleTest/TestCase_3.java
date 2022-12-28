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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestCase_3 {
    Login login = new Login();
    PitonDashboardPage pitonDashboardPage = new PitonDashboardPage();
    PitonCreateEventPage pitonCreateEventPage = new PitonCreateEventPage();
    private static Logger logger = LogManager.getLogger(tests.p2_EventModuleTest.TestCase_3.class.getName());

    @Test
    public void test03() {
        login.login();
        logger.info("Kullanici, verilen url'ye gider");

        pitonDashboardPage.createEventButton.click();
        logger.info("Kullanici, 'Create Event' butonuna tiklar");

        List<WebElement> numberOfParticipantList1= Driver.getDriver().findElements(By.xpath("//tr/td[1]"));
        System.out.println(numberOfParticipantList1.size());
        logger.info("Kullanici, participant sayisini bir List'e atar ve size'ini konsola yazdirir");
        // Bu adimda table kullanarak # altindaki sayilari bir List'e atiyoruz
        // 'Add Participant' butonuna tiklandiktan sonra yeni bir satirin eklenip eklenmedigini
        // bu List'in ve ileride olusturulacak List'in size'larini karsilastirarak ogrenecegiz

        pitonCreateEventPage.addParticipantButton.click();
        logger.info("Kullanici, 'Add Participant' butonuna tiklar");

        List<WebElement> numberOfParticipantList2=Driver.getDriver().findElements(By.xpath("//tr/td[1]"));
        System.out.println(numberOfParticipantList2.size());
        logger.info("Kullanici, participant sayisini bir List'e atar ve size'ini konsola yazdirir");
        // Bu adimda 'Add Participant' butonuna tiklandiktan sonra table'daki # altinda yer alan sayilari yeni bir List'e atiyoruz

        if (numberOfParticipantList2.size()>numberOfParticipantList1.size()){
            System.out.println("'Add Participant' butonuna tiklandiginda yeni bir satir eklenebiliyor");
        } else System.out.println("'Add Participant' butonuna tiklandiginda yeni bir satir eklenemiyor");
        // Bu adimda butona tiklandiktan sonra olusturulan List'in size'i ile onceden olusturulan List'in size'i karsilastiriliyor
        // Eger sonradan olusturulan List'in size'i digerinden buyuk ise 'Add Participant' butonuna tiklaninca
        // yeni bir kayit olusturulabiliyor demektir


        Driver.closeDriver();
        logger.info("Kullanici, driver'i kapatir");
    }
}
