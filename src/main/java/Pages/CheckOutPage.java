package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    protected WebDriver driver;

    @FindBy(name="firstName")
    private WebElement firstNameInput;

    @FindBy(name="lastName")
    private WebElement lastNameInput;

    @FindBy(name="postalCode")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement btnContinue;

    @FindBy(id = "finish")
    private WebElement btnFinish;

    public CheckOutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void informationInput(String firstName,String lastName,String postalCode){
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);

        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);

        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

        btnContinue.click();
        btnFinish.click();

    }
}
