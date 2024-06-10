package pl.coderslab.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingAdressPage {

    public WebDriver driver;


    @FindBy(xpath = "//*[@id='content']/div[3]/a/span")
    private WebElement createNewAdressBtn;
    @FindBy(xpath = "//*[@id='field-alias']")
    private WebElement aliasTxt;
    @FindBy(xpath = "//*[@id='field-address1']")
    private WebElement adressTxt;
    @FindBy(xpath = "//*[@id='field-city']")
    private WebElement cityTxt;
    @FindBy(xpath = "//*[@id='field-postcode']")
    private WebElement postalCodeTxt;

    @FindBy(xpath = "//*[@id='field-phone']")
    private WebElement phoneTxt;
    @FindBy(xpath = "//*[@id='content']/div/div/form/footer/button")
    private WebElement acceptFormBtn;

    public CreatingAdressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createAdress(String alias, String adress, String city, String postalcode, String phone){
        createNewAdressBtn.click();
        aliasTxt.sendKeys(alias);
        adressTxt.sendKeys(adress);
        cityTxt.sendKeys(city);
        postalCodeTxt.sendKeys(postalcode);
        phoneTxt.sendKeys(phone);
        acceptFormBtn.click();
    }



}