package tests.p3_DashboardModuleTest;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.PitonCreateEventPage;
import pages.PitonDashboardPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Login;
import java.util.List;

public class TestCase_6 {

    Login login = new Login();
    PitonDashboardPage pitonDashboardPage = new PitonDashboardPage();
    PitonCreateEventPage pitonCreateEventPage = new PitonCreateEventPage();
    Faker faker = new Faker();
    SoftAssert softAssert=new SoftAssert();
    private static Logger logger = LogManager.getLogger(tests.p3_DashboardModuleTest.TestCase_6.class.getName());
    @Test
    public void test06() {
        login.login();
        logger.info("Kullanici, verilen url'ye gider");

        pitonDashboardPage.createEventButton.click();
        logger.info("Kullanici, 'Create Event' butonuna tiklar");

        pitonCreateEventPage.eventNameBox.sendKeys(ConfigReader.getProperty("eventName1"));
        logger.info("Kullanici, 'Event Name' kismina bilgi girisi yapar");

        pitonCreateEventPage.eventDescriptionBox.sendKeys(ConfigReader.getProperty("eventDescription1"));
        logger.info("Kullanici, 'Event Description' kismina bilgi girisi yapar");

        pitonCreateEventPage.eventDateBox.sendKeys("2023");
        logger.info("Kullanici, 'Event Date' kismina bilgi girisi yapar");

        pitonCreateEventPage.firstNameBox.sendKeys(faker.name().firstName());
        String firstName=pitonCreateEventPage.firstNameBox.getText();
        logger.info("Kullanici, 'First Name' kismina bilgi girisi yapar ve girilen ismi bir container'e atar");

        pitonCreateEventPage.lastNameBox.sendKeys(faker.name().lastName());
        logger.info("Kullanici, 'Last Name' kismina bilgi girisi yapar");

        pitonCreateEventPage.contactBox.sendKeys(faker.internet().emailAddress());
        logger.info("Kullanici, 'Contact' kismina bilgi girisi yapar");

        pitonCreateEventPage.createNewEventButton.click();
        logger.info("Kullanici, 'Create New Event' butonuna tiklar");

        pitonDashboardPage.participantsButton.click();
        logger.info("Kullanici, participants iconuna tiklar");


        List<WebElement> titles=Driver.getDriver().findElements(By.xpath("//tr/th"));

        int temp=0;
        for (int i = 0; i < titles.size() ; i++) {
            if (titles.get(i).getText().contains("First Name")){
                temp=i;
            }
        }
        System.out.println(temp);

        List<WebElement> elements=Driver.getDriver().findElements(By.xpath("//tr/td"));

        softAssert.assertEquals(elements.get(temp),firstName);
        logger.info("Kullanici, participants'i goruntuleyebildigini dogrular");

        /*
        61 ve 73. satirlar arasinda yapilan islemleri kisaca anlatmak gerekirse;
         - Yukarida event create edilirken 'First Name' kismina yazilan bilgi String bir container'a atanmisti.
         - 61. satirda, table'lardaki basliklar bir List'e atildi ve bunlar for dongusune sokuldu,
           for dongusunde List'in kacinci indexinin 'First Name'e denk geldigi bulundu ve bu index 'temp' degiskenine atandi.
         - 71. satirda ise basliklarin altinda yer alan elementler bir farkli bir List'e atildi.
         - titles List'inde 'First Name' basligina denk gelen index ile bu basligin altina denk gelen ismi
           ilk basta String'e atanan 'firstName' degiskeni ile karsilastirildi. Esit oldugu gozlemlendi
           ve participants'in goruntulenebildigi dogrulandi.
         */

        Driver.closeDriver();
        logger.info("Kullanici, driver'i kapatir");
    }
}
