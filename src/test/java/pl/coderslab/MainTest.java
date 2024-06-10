package pl.coderslab;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/gggy/Desktop/ONL_TEA_W_49_Dzien_4_-_Selenium_WebDriver-main-2/Zaliczenie/src/test/resources/Cucumber/Features/myshop-firstorder.feature",
        plugin = {"pretty", "html:test_report.html"}
)
public class MainTest {
}