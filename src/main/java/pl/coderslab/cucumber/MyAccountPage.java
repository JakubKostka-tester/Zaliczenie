package pl.coderslab.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    public WebDriver driver;


    @FindBy(xpath = "//*[@id='addresses-link']/span/i")
    private WebElement addAdressBtn;
    @FindBy(xpath = "//*[@id='_desktop_logo']/a/img")
    private WebElement goMainPage;
    @FindBy(xpath = "//*[@id='history-link']/span/i")
    private WebElement orderHistory;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void addAdress(){
        addAdressBtn.click();
    }
    public void goMain(){
        goMainPage.click();
    }

    public void orderHistory(){
        orderHistory.click();
    }



}