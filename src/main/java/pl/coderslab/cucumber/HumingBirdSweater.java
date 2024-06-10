package pl.coderslab.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HumingBirdSweater {

    public WebDriver driver;


    @FindBy(xpath = "//*[@id='quantity_wanted']")
    private WebElement ammountOf;
    @FindBy(xpath = "//*[@id='add-to-cart-or-refresh']/div[2]/div/div[1]/div/span[3]/button[1]/i")
    private WebElement changeAmmount;
    @FindBy(xpath = "//*[@id='add-to-cart-or-refresh']/div[2]/div/div[2]")
    private WebElement addToCart;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement procedeToCheckout;
    @FindBy(xpath = "//*[@id='main']/div/div[2]/div[1]/div[2]/div/a")
    private WebElement procedeToCheckout1;

    public HumingBirdSweater(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setAmmountOf(int ammount){
        for (int i = 0; i<=ammount+1; i++){
            changeAmmount.click();
        }
    }
    public void addToCart(){
        addToCart.click();
        procedeToCheckout.click();

    }
    public void procedeToCheckout1(){
        procedeToCheckout1.click();
    }


}