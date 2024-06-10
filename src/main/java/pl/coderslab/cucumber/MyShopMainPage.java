package pl.coderslab.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class MyShopMainPage {

    public WebDriver driver;


    @FindBy(xpath = "//*[@id='_desktop_user_info']/div/a/span")
    private WebElement signInBtn;
    @FindBy(xpath = "//*[@id='content']/section/div/div[2]/article/div/div[1]/a/img")
    private WebElement humingbirdSweater;

    @FindBy(xpath = "//*[@id='order-items']/div[2]/table/tbody/tr[4]/td[2]")
    private WebElement actualPrice;




    public MyShopMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPrice(){
        return actualPrice.getText();
    }

    public void hummingBirdSweater(){
        humingbirdSweater.click();
    }


    public void clickSignIn(){
        signInBtn.click();

    }
    public String checkDisc() {
        WebElement disc = driver.findElement(By.xpath("//*[@id='main']/div[1]/div[2]/div[1]/div[2]/div/span[2]"));
        return disc.getText();
    }




}
