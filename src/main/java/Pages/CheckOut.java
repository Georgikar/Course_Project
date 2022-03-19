package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut {

    protected WebDriver driver;

    @FindBy(name="firstName")
    private WebElement firstNameInput;

    @FindBy(name="lastName")
    private WebElement lastNameInput;

    @FindBy(name="postalCode")
    private WebElement postalCodeInput;

    public CheckOut(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void informationInput(String firstName, String lastName, int postalCode){
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);

        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);

        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);


    }
}
