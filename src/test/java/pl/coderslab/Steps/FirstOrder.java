package pl.coderslab.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pl.coderslab.cucumber.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FirstOrder {

    private WebDriver driver;
    private MyShopMainPage myshop;


    private static String cena;


    @Given("Uzytkownik {word} {word} jest zalogowany na stronie myshop")
    public void openBrowser(String login, String haslo) {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.manage().window().maximize();
        this.driver.get("https://mystore-testlab.coderslab.pl");
        myshop = new MyShopMainPage(this.driver);
        myshop.clickSignIn();
        LoginPage logIN = new LoginPage(this.driver);
        logIN.loginWithCredentials(login, haslo);


    }

    @When("Uzytkownik dodaj produkt do koszyka {word} {int} i finalizuje platnosc")
    public void addProduct(String size, int ammount) {
        MyAccountPage konto = new MyAccountPage(this.driver);
        konto.goMain();
        myshop.hummingBirdSweater();
        MyShopMainPage disc = new MyShopMainPage(this.driver);
        String discountAmount = disc.checkDisc();
        assertEquals("SAVE 20%", discountAmount);
        Select drpSize = new Select(driver.findElement(By.name("group[1]")));
        drpSize.selectByVisibleText(size);
        HumingBirdSweater sweater = new HumingBirdSweater(this.driver);
        sweater.setAmmountOf(ammount);
        sweater.addToCart();
        sweater.procedeToCheckout1();
        OrderConfirmation confirm = new OrderConfirmation(this.driver);
        confirm.adressContinue();
        confirm.ShipingContinue();
        confirm.placeOrder();
        cena = myshop.getPrice();
    }

    @Then("Zamowienie zostalo zrealizowane")
    public void orderFinished() {
        WebElement successAlert = this.driver.findElement(By.xpath("//*[@id='content-hook_order_confirmation']/div/div/div/h3"));
        String expectedSuccessAlertText = "YOUR ORDER IS CONFIRMED";
        boolean finishedPayment = successAlert.getText().contains(expectedSuccessAlertText);
        assert (finishedPayment);

    }

    @And("Zrzut ekranu")
    public void ScreenShot() throws IOException {
        String imageNew = "/Users/gggy/Desktop/ONL_TEA_W_49_Dzien_4_-_Selenium_WebDriver-main-2/Zaliczenie./image" + new Random().nextInt(1000000) + ".png";
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(imageNew));
    }


    @And("Cena jest taka sama w historii zmaowien")
    public void checkPrice(){
        OrderConfirmation order = new OrderConfirmation(this.driver);
        order.GoMyAccount();
        MyAccountPage konto = new MyAccountPage(this.driver);
        konto.orderHistory();
        OrderHistory orderprice = new OrderHistory(this.driver);
        assertEquals(orderprice.GetLastOrderPrice(), cena);

    }


}




