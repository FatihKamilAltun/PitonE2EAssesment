package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PitonLoginPage {
    public PitonLoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//div[text()=' Event Manager Login ']")
    public WebElement loginPageTitle;
    @FindBy (xpath = "//input[@id='username']")
    public WebElement usernameBox;

    @FindBy (xpath = "//mat-label[text()='Username']")
    public WebElement usernameText;

    @FindBy (xpath = "//mat-error[text()='Username field is required']")
    public WebElement usernameErrorText;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement passwordBox;

    @FindBy (xpath = "//mat-label[text()='Password']")
    public WebElement passwordText;

    @FindBy (xpath = "//mat-error[text()='Password field is required']")
    public WebElement passwordErrorText;

    @FindBy (xpath = "//span[text()='Login']")
    public WebElement logginButton;

    @FindBy (xpath = "//span[text()='Login']")
    public WebElement logginButtonText;
}
