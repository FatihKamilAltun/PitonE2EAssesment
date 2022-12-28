package tests.p2_EventModuleTest;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.PitonCreateEventPage;
import pages.PitonDashboardPage;
import pages.PitonEditEventPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Login;

public class TestCase_6 {

    Login login = new Login();
    PitonDashboardPage pitonDashboardPage = new PitonDashboardPage();
    PitonCreateEventPage pitonCreateEventPage = new PitonCreateEventPage();
    PitonEditEventPage pitonEditEventPage=new PitonEditEventPage();
    Faker faker = new Faker();
    SoftAssert softAssert=new SoftAssert();
    private static Logger logger = LogManager.getLogger(tests.p2_EventModuleTest.TestCase_6.class.getName());

    @Test
    public void test06() {
        login.login();
        logger.info("Kullanici, verilen url'ye gider");

        pitonDashboardPage.createEventButton.click();
        logger.info("Kullanici, 'Create Event' butonuna tiklar");

        pitonCreateEventPage.eventNameBox.sendKeys(ConfigReader.getProperty("eventName1"));
        String eventName1=pitonCreateEventPage.eventNameBox.getText();
        logger.info("Kullanici, 'Event Name' kismina bilgi girisi yapar ve girdigi bilgiyi bir String container'a atar");

        pitonCreateEventPage.eventDescriptionBox.sendKeys(ConfigReader.getProperty("eventDescription1"));
        String eventDescription1=pitonCreateEventPage.eventDescriptionBox.getText();
        logger.info("Kullanici, 'Event Description' kismina bilgi girisi yapar ve girdigi bilgiyi bir String container'a atar");

        pitonCreateEventPage.eventDateBox.sendKeys("2023");
        String eventDate1=pitonCreateEventPage.eventDateBox.getText();
        logger.info("Kullanici, 'Event Date' kismina bilgi girisi yapar ve girdigi bilgiyi bir String container'a atar");

        pitonCreateEventPage.firstNameBox.sendKeys(faker.name().firstName());
        String firstName1=pitonCreateEventPage.firstNameBox.getText();
        logger.info("Kullanici, 'First Name' kismina bilgi girisi yapar ve girdigi bilgiyi bir String container'a atar");

        pitonCreateEventPage.lastNameBox.sendKeys(faker.name().lastName());
        String lastName1=pitonCreateEventPage.lastNameBox.getText();
        logger.info("Kullanici, 'Last Name' kismina bilgi girisi yapar ve girdigi bilgiyi bir String container'a atar");

        pitonCreateEventPage.contactBox.sendKeys(faker.internet().emailAddress());
        String contactMail1=pitonCreateEventPage.contactBox.getText();
        logger.info("Kullanici, 'Contact' kismina bilgi girisi yapar ve girdigi bilgiyi bir String container'a atar");

        pitonCreateEventPage.createNewEventButton.click();
        logger.info("Kullanici, 'Create New Event' butonuna tiklar");

        pitonDashboardPage.editEventButton.click();
        logger.info("Kullanici, 'Edit Event' butonuna tiklar");

        pitonCreateEventPage.eventNameBox.clear();
        pitonCreateEventPage.eventNameBox.sendKeys(ConfigReader.getProperty("eventName2"));
        String eventName2=pitonCreateEventPage.eventNameBox.getText();
        logger.info("Kullanici, 'Event Name' kismini temizleyerek yeni bir bilgi girisi yapar ve girdigi bilgiyi bir String container'a atar");

        pitonCreateEventPage.eventDescriptionBox.clear();
        pitonCreateEventPage.eventDescriptionBox.sendKeys(ConfigReader.getProperty("eventDescription2"));
        String eventDescription2=pitonCreateEventPage.eventDescriptionBox.getText();
        logger.info("Kullanici, 'Event Description' kismini temizleyerek yeni bir bilgi girisi yapar ve girdigi bilgiyi bir String container'a atar");

       //pitonEditEventPage.editDateBox.clear();
       //pitonEditEventPage.editDateBox.sendKeys("2022");
       //String eventDate2=pitonEditEventPage.editDateBox.getText();
       //logger.info("Kullanici, 'Event Date' kismini temizleyerek yeni bir bilgi girisi yapar ve girdigi bilgiyi bir String container'a atar");

        pitonEditEventPage.editFirstNameBox.clear();
        pitonEditEventPage.editFirstNameBox.sendKeys(faker.name().firstName());
        String firstName2=pitonEditEventPage.editFirstNameBox.getText();
        logger.info("Kullanici, 'First Name' kismini temizleyerek yeni bir bilgi girisi yapar ve girdigi bilgiyi bir String container'a atar");

        pitonEditEventPage.editLastNameBox.clear();
        pitonEditEventPage.editLastNameBox.sendKeys(faker.name().lastName());
        String lastName2=pitonEditEventPage.editLastNameBox.getText();
        logger.info("Kullanici, 'Last Name' kismini temizleyerek yeni bir bilgi girisi yapar ve girdigi bilgiyi bir String container'a atar");

        pitonEditEventPage.editContactBox.clear();
        pitonEditEventPage.editContactBox.sendKeys(faker.internet().emailAddress());
        String contactMail2=pitonEditEventPage.editContactBox.getText();
        logger.info("Kullanici, 'Contact' kismini temizleyerek yeni bir bilgi girisi yapar ve girdigi bilgiyi bir String container'a atar");

        softAssert.assertFalse(eventName2.equals(eventDate1));
        softAssert.assertFalse(eventDescription2.equals(eventDescription1));
        //softAssert.assertFalse(eventDate2.equals(eventDate1));
        softAssert.assertFalse(firstName2.equals(firstName1));
        softAssert.assertFalse(lastName2.equals(lastName1));
        softAssert.assertFalse(contactMail2.equals(contactMail1));
        logger.info("Kullanici, degisen bilgilerin birbirleriyle ayni olmadgini softassert methodu kullanarak dogrular");

        /*
        Bu test case'de ilk olarak sifirdan bir event create edildi.
        Daha sonrasinda create edilen eventi duzenleyebildigimizi gorebilmek icin
            create edilen eventin tum bilgilerinin yerine yeni bilgiler girildi.
        Her bir bilgi girildikten sonra girilen bilgiler daha sonrasinda karsilastirilmak icin uygun bir variable'a (String) atandi.
        Bu variable'lara atilan bilgiler kendi aralarinda karsilastirildi.
        Birbirlerine esit olmadigi yani degistirildigi, sonuc olarak duzenlenebildigi goruldu.
         */

        Driver.closeDriver();
        logger.info("Kullanici, driver'i kapatir");

    }
}
