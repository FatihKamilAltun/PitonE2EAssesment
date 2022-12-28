package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PitonEditEventPage {
    public PitonEditEventPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[text()='Update Event']")
    public WebElement updateEventButton;

    @FindBy(xpath = "//input[@id='mat-input-10']")
    public WebElement editDateBox;

    @FindBy(xpath = "//input[@id='mat-input-11']")
    public WebElement editFirstNameBox;

    @FindBy(xpath = "//input[@id='mat-input-12']")
    public WebElement editLastNameBox;

    @FindBy(xpath = "//input[@id='mat-input-13']")
    public WebElement editContactBox;
}
