package pl.coderslab.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.cucumber.*;


import java.time.Duration;

import static org.junit.Assert.*;

public class LogInAndAddAdress {

    private WebDriver driver;
    private MyShopMainPage myshop;
    private LoginPage login;



    @Given("przegladarka jest otworzona na stronie myshop")
    public void openBrowser() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.get("https://mystore-testlab.coderslab.pl");
        this.driver.manage().window().maximize();
        myshop = new MyShopMainPage(this.driver);

    }

    @When("uzytkownik przechodzi do okna logowania i wpisuje dane {word} {word}")
    public void signInPage(String login, String haslo) {
        myshop.clickSignIn();
        LoginPage logIN = new LoginPage(this.driver);
        logIN.loginWithCredentials(login,haslo);
        MyAccountPage addAdress = new MyAccountPage(this.driver);
        addAdress.addAdress();
    }


    @Then("uzytkownik jest przekierowany na strone glowna")
    public void accountIsCreated() {
        String Url = "https://mystore-testlab.coderslab.pl/index.php?controller=addresses";
        try {
            String successAlert = this.driver.getCurrentUrl();
            assertEquals(Url, successAlert);
        } catch (NoSuchElementException ex) {
            fail("Jestes na zlej stronie");
        }

    }

    @When("uzytkownik dodaje adres {word} {word} {word} {word} {word}")
    public void userAddNewAdress(String alias, String adress, String city, String postalcode, String phone) {
        CreatingAdressPage adressCreate = new CreatingAdressPage(this.driver);
        adressCreate.createAdress(alias, adress, city, postalcode, phone);
    }

    @Then("adres zostal stworzony z poprawnymi danymi {word} {word} {word} {word} {word}")
    public void userAddressVerification(String alias, String address, String city, String postalCode, String phone) {
        WebElement addressCheck = driver.findElement(By.xpath("//section[@id='content']/div[last()-2]"));

        String addressTxt = addressCheck.getText();

        boolean test = addressTxt.contains(alias);
        boolean test2 = addressTxt.contains(address);
        boolean test3 = addressTxt.contains(city);
        boolean test4 = addressTxt.contains(postalCode);
        boolean test5 = addressTxt.contains(phone);

        try {
            assertTrue("Address does contain all expected data", test&&test2&&test3&&test4&&test5);
        } catch (AssertionError e) {
            fail("Dane się różnią");
            throw e;
        }



        driver.quit();
    }

    }

