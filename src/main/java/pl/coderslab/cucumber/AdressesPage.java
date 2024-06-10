package pl.coderslab.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdressesPage {

    public WebDriver driver;


    @FindBy(xpath = "//*[@id='content']/div[3]/a/span")
    private WebElement createNewAdressBtn;
    @FindBy(xpath = "/html/body/main/section/div/div/section/section/div[2]/article/div[2]/a[2]/span")
    private WebElement deleteAdressBtn;


    public AdressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String checkAdress() {
        WebElement adress = driver.findElement(By.className("//section[@id='content']/div[last()-2]"));
        return adress.getText();
    }
    public void deleteAdress() {
        deleteAdressBtn.click();
    }

    public String getAlertText() {
        WebElement alert = driver.findElement(By.xpath("//*[@id='notifications']/div/article/ul/li"));
        return alert.getText();
    }

    public void addAdress(){
        createNewAdressBtn.click();
    }



}