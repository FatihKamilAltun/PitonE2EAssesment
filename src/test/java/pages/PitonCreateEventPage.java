package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PitonCreateEventPage {
    public PitonCreateEventPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1[text()='Create Event']")
    public WebElement createEventTitle;

    @FindBy(xpath = "//span[text()='Create New Event']")
    public WebElement createNewEventButton;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement eventNameBox;

    @FindBy(xpath = "//mat-error[text()='Event name field is required']")
    public WebElement eventNameErrorText;

    @FindBy(xpath = "//input[@id='description']")
    public WebElement eventDescriptionBox;

    @FindBy(xpath = "//input[@id='mat-input-4']")
    public WebElement eventDateBox;

    @FindBy(xpath = "//mat-error[text()='Please choose a valid date']")
    public WebElement eventDateErrorText;

    @FindBy(xpath = "//span[text()='Add Participant']")
    public WebElement addParticipantButton;

    @FindBy(xpath = "//mat-icon[@class='mat-icon notranslate material-icons mat-icon-no-color']")
    public WebElement deleteParticipantButton;

    @FindBy(xpath = "//p[text()='Please add participant!']")
    public WebElement participantsErrorMessage;

    @FindBy(xpath = "//tr/td[1]")
    public WebElement numberOfParticipant;

    @FindBy(xpath = "//input[@id='mat-input-5']")
    public WebElement firstNameBox;

    @FindBy(xpath = "//input[@id='mat-input-6']")
    public WebElement lastNameBox;

    @FindBy(xpath = "//input[@id='mat-input-7']")
    public WebElement contactBox;

    @FindBy(xpath = "//mat-error[text()='Participant name is required']")
    public WebElement participantNameErrorText;

    @FindBy(xpath = "//mat-error[text()='Participant last name is required']")
    public WebElement participantLastNameErrorText;

    @FindBy(xpath = "//mat-error[text()='Please enter email or phone number']")
    public WebElement emailOrPhoneErrorText;


}
