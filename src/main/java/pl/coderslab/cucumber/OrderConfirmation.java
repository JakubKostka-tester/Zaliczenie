package pl.coderslab.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmation {

    public WebDriver driver;


    @FindBy(xpath = "//*[@id='_desktop_user_info']/div/a[2]/span")
    private WebElement goMyAccount;
    @FindBy(xpath = "//*[@id='checkout-addresses-step']/div/div/form/div[2]/button")
    private WebElement adressContinue;
    @FindBy(xpath = "//*[@id='js-delivery']/button")
    private WebElement shipingContinue;
    @FindBy(xpath = "//*[@id='payment-option-1']")
    private WebElement payByCheck;
    @FindBy(xpath = "//*[@id='conditions_to_approve[terms-and-conditions]']")
    private WebElement conditionsToAprove;
    @FindBy(xpath = "//*[@id='payment-confirmation']/div[1]/button")
    private WebElement placeOrder;



    public OrderConfirmation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void GoMyAccount(){
        goMyAccount.click();
    }

    public void adressContinue() {
        adressContinue.click();
    }

    public void ShipingContinue(){
        shipingContinue.click();
    }

    public void placeOrder(){
        payByCheck.click();
        conditionsToAprove.click();
        placeOrder.click();
    }





}