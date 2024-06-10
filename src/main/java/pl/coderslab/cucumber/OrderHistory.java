package pl.coderslab.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistory {

    public WebDriver driver;


    @FindBy(xpath = "/html/body/main/section/div/div/section/section/table/tbody/tr[1]/td[2]")
    private WebElement getLastOrderPrice;


    public OrderHistory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String GetLastOrderPrice(){
       return  getLastOrderPrice.getText();
    }




}