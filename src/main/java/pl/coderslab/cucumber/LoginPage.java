package pl.coderslab.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;


    @FindBy(xpath = "//*[@id='field-email']")
    private WebElement loginTxt;
    @FindBy(xpath = "//*[@id='field-password']")
    private WebElement passwordTxt;
    @FindBy(xpath = "//*[@id='submit-login']")
    private WebElement signInBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginWithCredentials(String login, String haslo){
        loginTxt.sendKeys(login);
        passwordTxt.sendKeys(haslo);
        signInBtn.click();
    }



}