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

public class UsuwanieAdresu {

    private WebDriver driver;
    private MyShopMainPage myshop;



    @Given("uzytkownik jest zalogowany na stronie myshop i dodal wczesniej adres")
    public void openBrowser() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.get("https://mystore-testlab.coderslab.pl");
        this.driver.manage().window().maximize();
        myshop = new MyShopMainPage(this.driver);

    }

    @When("uzytkownik loguje sie {word} {word}")
    public void signInPage(String login, String haslo) {
        myshop.clickSignIn();
        LoginPage logIN = new LoginPage(this.driver);
        logIN.loginWithCredentials(login,haslo);
        MyAccountPage addAdress = new MyAccountPage(this.driver);
        addAdress.addAdress();
    }

    @And("uzytkownik usuwa adres")
    public void deleteAdress() {
    AdressesPage delete = new AdressesPage(this.driver);
    delete.deleteAdress();

    }


    @Then("adress zostal usuniety")
    public void accountIsCreated() {
        try {
           AdressesPage alert = new AdressesPage(this.driver);
           String successAlert = alert.getAlertText();
            assertEquals("Address successfully deleted!", successAlert);
        } catch (NoSuchElementException ex) {
            fail("Alert o sukcesie sie nie pojawil");
        } finally {
            driver.quit();
        }

    }




    }

