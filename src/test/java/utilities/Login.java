package utilities;

import pages.PitonLoginPage;

public class Login {


    public void login(){
        PitonLoginPage pitonLoginPage=new PitonLoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        pitonLoginPage.usernameBox.sendKeys(ConfigReader.getProperty("username"));
        pitonLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        pitonLoginPage.logginButton.click();

    }
}
