package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PitonDashboardPage {

    public PitonDashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//strong[text()='Welcome Automation Test User']")
    public WebElement welcomeText;

    @FindBy (xpath = "//span[text()='Create Event']")
    public WebElement createEventButton;

    @FindBy(xpath = "//button[@title='Edit Event']")
    public WebElement editEventButton;

    @FindBy(xpath = "//button[@title='Participants']")
    public WebElement participantsButton;

    @FindBy(xpath = "//button[@title='Delete Event']")
    public WebElement deleteEventButton;

    @FindBy(xpath = "//h2[@class='mat-dialog-title']")
    public WebElement participantsOfEventText;

}
